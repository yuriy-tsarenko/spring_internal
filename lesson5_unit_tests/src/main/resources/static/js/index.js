let appLoader = new Vue({
    el: '#loader',
    data: {
        flag: false
    }
});

let appCount = new Vue({
    el: '#appCount',
    data: {
        number: 0
    }
});

Vue.component('word-row', {
    props: ['word'],
    template:
        '<div>' +
        ' <table class="wordTable">' +
        '   <tr>' +
        '      <td>' +
        '         <div>' +
        '               {{word.word}} - ' + '{{word.uniqueLettersCount}}' +
        '         </div>' +
        '      </td>' +
        '   </tr>' +
        ' </table>' +
        '</div>'
});

Vue.component('words-list', {
    props: ['words'],
    template: '<div>' +
        '<word-row v-for="word in words" :key="word.id" :word="word"/>' +
        '</div>'
});

let words = new Vue({
    el: '#appWords',
    template: '<words-list :words="words" />',
    data: {
        words: []
    }
});

let textForm = new Vue({
    el: '#appForm',
    data: {
        words: ''
    },
    methods: {
        submitWords: function () {
            appLoader.flag = !appLoader.flag;
            let text = this.words;
            words.words = words.words.splice(0, 0);
            setTimeout(function () {
                let formData = new FormData();
                formData.append('text', text);
                axios.post('/word/save',
                    formData,
                    {
                        headers: {
                            'Content-Type': 'multipart/form-data'
                        }
                    }
                ).then(response => response.data.forEach(word => words.words.push(word)))
                    .then(x => appCount.number = words.words.length);
                appLoader.flag = !appLoader.flag;
            }, 1000);
            this.words = '';
        }
    }
});