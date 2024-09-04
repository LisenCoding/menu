const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm1m683/",
            name: "ssm1m683",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm1m683/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "菜谱小程序"
        } 
    }
}
export default base
