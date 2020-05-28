new Vue({
    el: "#app",
    data: {
        globalColor: true,
        shiftColor: true,
        spaceColor: true,
        colorChange: false,
        active: -1,
        active4Line1: -1,
        //风格组
        items4Style: [
            {message: '1'},
            {message: '2'},
            {message: '3'},
            {message: '4'}
        ],
        //字母第一行
        items4Line1: [
            {message: 'Q'},
            {message: 'W'},
            {message: 'E'},
            {message: 'R'},
            {message: 'T'},
            {message: 'Y'},
            {message: 'U'},
            {message: 'I'},
            {message: 'O'},
            {message: 'P'},
        ],
        //字母第2行
        items4Line2: [
            {message: 'A'},
            {message: 'S'},
            {message: 'D'},
            {message: 'F'},
            {message: 'G'},
            {message: 'H'},
            {message: 'J'},
            {message: 'K'},
            {message: 'L'},
        ],
        //←shift
        items4LineSHIFT: [
            {message: 'SHIFT'},
        ],
        //字母第3行
        items4Line3: [
            {message: 'Z'},
            {message: 'X'},
            {message: 'C'},
            {message: 'V'},
            {message: 'B'},
            {message: 'N'},
            {message: 'M'},
        ],
        //items4SPACE
        items4SPACE: [
            {message: 'SPACE'},
        ]
    },
    methods: {
        handleClick(message) {
            if (message == " ") {
                this.active = 'SPACE';
            }else {
                this.active = message.toUpperCase();
            }
        },
    },
    //如果需要相关的数据改变才调用方法，则使用计算属性（性能比放在Method中好，method中无论数据改变与否，都会调用）
    computed: {
        styleClass() {
            return {
                globalKey: this.globalColor,
                changeColor: this.colorChange
            }
        },
        styleClass4SHIFT() {
            return {
                shift: this.shiftColor,
                changeColor: this.colorChange
            }
        },
        styleClass4SPACE() {
            return {
                space: this.spaceColor,
                changeColor: this.colorChange
            }
        }
    },
    created() {
        let _this = this;
        //注册键盘事件
        document.onkeydown = function (e) {
            let key = e.key;
            _this.handleClick(key);
        },
        document.onkeyup = function (e) {
            _this.active = -1;
        }
    },
    watch: {}

});