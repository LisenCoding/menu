(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/shicaizhanshi/list"],{"00df":function(e,t,i){},"2ebc":function(e,t,i){"use strict";(function(e){i("5d38");n(i("66fd"));var t=n(i("5149"));function n(e){return e&&e.__esModule?e:{default:e}}e(t.default)}).call(this,i("543d")["createPage"])},"48c0":function(e,t,i){"use strict";i.r(t);var n=i("ec26"),r=i.n(n);for(var a in n)"default"!==a&&function(e){i.d(t,e,(function(){return n[e]}))}(a);t["default"]=r.a},"4f23":function(e,t,i){"use strict";var n=i("00df"),r=i.n(n);r.a},5149:function(e,t,i){"use strict";i.r(t);var n=i("5bbb"),r=i("48c0");for(var a in r)"default"!==a&&function(e){i.d(t,e,(function(){return r[e]}))}(a);i("4f23");var s,c=i("f0c5"),o=Object(c["a"])(r["default"],n["b"],n["c"],!1,null,null,null,!1,n["a"],s);t["default"]=o.exports},"5bbb":function(e,t,i){"use strict";i.d(t,"b",(function(){return r})),i.d(t,"c",(function(){return a})),i.d(t,"a",(function(){return n}));var n={mescrollUni:function(){return Promise.all([i.e("common/vendor"),i.e("components/mescroll-uni/mescroll-uni")]).then(i.bind(null,"c2ea"))}},r=function(){var e=this,t=e.$createElement,i=(e._self._c,e.isAuth("shicaizhanshi","修改")),n=e.isAuthFront("shicaizhanshi","修改"),r=e.isAuth("shicaizhanshi","删除"),a=e.isAuthFront("shicaizhanshi","删除"),s=e.__map(e.list,(function(t,i){var n=e.__get_orig(t),r=t.shicaitupian?t.shicaitupian.split(","):null;return{$orig:n,g0:r}})),c=e.isAuth("shicaizhanshi","新增"),o=e.isAuthFront("shicaizhanshi","新增");e.$mp.data=Object.assign({},{$root:{m0:i,m1:n,m2:r,m3:a,l0:s,m4:c,m5:o}})},a=[]},ec26:function(e,t,i){"use strict";(function(e){Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0;var n=r(i("a34a"));function r(e){return e&&e.__esModule?e:{default:e}}function a(e,t,i,n,r,a,s){try{var c=e[a](s),o=c.value}catch(u){return void i(u)}c.done?t(o):Promise.resolve(o).then(n,r)}function s(e){return function(){var t=this,i=arguments;return new Promise((function(n,r){var s=e.apply(t,i);function c(e){a(s,n,r,c,o,"next",e)}function o(e){a(s,n,r,c,o,"throw",e)}c(void 0)}))}}var c={data:function(){return{btnColor:["#409eff","#67c23a","#909399","#e6a23c","#f56c6c","#356c6c","#351c6c","#f093a9","#a7c23a","#104eff","#10441f","#a21233","#503319"],queryList:[{queryName:"食材名称"}],sactiveItem:{padding:"0 28rpx",boxShadow:"0 0 12rpx rgba(0,0,0,.3)",margin:"0 12rpx",borderColor:"rgba(0,0,0,1)",backgroundColor:"rgba(130, 163, 157, 1)",color:"#fff",borderRadius:"8rpx",borderWidth:"0",width:"auto",lineHeight:"70rpx",fontSize:"28rpx",borderStyle:"solid"},sitem:{padding:"0 20rpx",boxShadow:"0 0 12rpx rgba(0,0,0,.3)",margin:"0 12rpx",borderColor:"rgba(0,0,0,1)",backgroundColor:"rgba(161, 161, 161, 1)",color:"rgba(255, 255, 255, 1)",borderRadius:"8rpx",borderWidth:"0",width:"auto",lineHeight:"70rpx",fontSize:"28rpx",borderStyle:"solid"},queryIndex:0,list:[],userid:"",mescroll:null,downOption:{auto:!1},upOption:{noMoreSize:5,textNoMore:"~ 没有更多了 ~"},hasNext:!0,searchForm:{},categoryList:[],categoryName:"全部",CustomBar:"0"}},computed:{baseUrl:function(){return this.$base.url}},onShow:function(){var t=this;return s(n.default.mark((function i(){var r;return n.default.wrap((function(i){while(1)switch(i.prev=i.next){case 0:if(1==e.getStorageSync("useridTag")?(t.userid=e.getStorageSync("useridTag"),e.removeStorageSync("useridTag")):t.userid="",t.btnColor=t.btnColor.sort((function(){return.5-Math.random()})),r={},!t.userid){i.next=9;break}return i.next=6,t.$api.page("shicaifenlei",{page:1,limit:100});case 6:r=i.sent,i.next=12;break;case 9:return i.next=11,t.$api.list("shicaifenlei",{page:1,limit:100});case 11:r=i.sent;case 12:r.data.list.splice(0,0,{id:0,shicaifenlei:"全部"}),t.categoryList=r.data.list,t.hasNext=!0,t.mescroll&&t.mescroll.resetUpScroll();case 16:case"end":return i.stop()}}),i)})))()},onLoad:function(t){1==e.getStorageSync("useridTag")?(this.userid=e.getStorageSync("useridTag"),e.removeStorageSync("useridTag")):this.userid="",this.hasNext=!0,this.mescroll&&this.mescroll.resetUpScroll()},methods:{queryChange:function(e){this.queryIndex=e.detail.value,this.searchForm.shicaimingcheng=""},categoryClick:function(e){this.categoryName=e,this.mescroll.resetUpScroll()},mescrollInit:function(e){this.mescroll=e},downCallback:function(e){this.hasNext=!0,e.resetUpScroll()},upCallback:function(e){var t=this;return s(n.default.mark((function i(){var r,a;return n.default.wrap((function(i){while(1)switch(i.prev=i.next){case 0:if(r={page:e.num,limit:e.size},"全部"!=t.categoryName&&(r.shicaifenlei="%"+t.categoryName+"%"),t.searchForm.shicaimingcheng&&(r["shicaimingcheng"]="%"+t.searchForm.shicaimingcheng+"%"),a={},!t.userid){i.next=10;break}return i.next=7,t.$api.page("shicaizhanshi",r);case 7:a=i.sent,i.next=13;break;case 10:return i.next=12,t.$api.list("shicaizhanshi",r);case 12:a=i.sent;case 13:1==e.num&&(t.list=[]),t.list=t.list.concat(a.data.list),0==a.data.list.length&&(t.hasNext=!1),e.endSuccess(e.size,t.hasNext);case 17:case"end":return i.stop()}}),i)})))()},onDetailTap:function(t){e.setStorageSync("useridTag",this.userid),this.$utils.jump("./detail?id=".concat(t.id,"&userid=")+this.userid)},onUpdateTap:function(t){e.setStorageSync("useridTag",this.userid),this.$utils.jump("./add-or-update?id=".concat(t))},onAddTap:function(){e.setStorageSync("useridTag",this.userid),this.$utils.jump("./add-or-update")},onDeleteTap:function(t){var i=this;e.showModal({title:"提示",content:"是否确认删除",success:function(){var e=s(n.default.mark((function e(r){return n.default.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(!r.confirm){e.next=5;break}return e.next=3,i.$api.del("shicaizhanshi",JSON.stringify([t]));case 3:i.hasNext=!0,i.mescroll.resetUpScroll();case 5:case"end":return e.stop()}}),e)})));function r(t){return e.apply(this,arguments)}return r}()})},search:function(){var e=this;return s(n.default.mark((function t(){var i,r;return n.default.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(e.mescroll.num=1,i={page:e.mescroll.num,limit:e.mescroll.size},e.searchForm.shicaimingcheng&&(i["shicaimingcheng"]="%"+e.searchForm.shicaimingcheng+"%"),r={},!e.userid){t.next=10;break}return t.next=7,e.$api.page("shicaizhanshi",i);case 7:r=t.sent,t.next=13;break;case 10:return t.next=12,e.$api.list("shicaizhanshi",i);case 12:r=t.sent;case 13:1==e.mescroll.num&&(e.list=[]),e.list=e.list.concat(r.data.list),0==r.data.list.length&&(e.hasNext=!1),e.mescroll.endSuccess(e.mescroll.size,e.hasNext);case 17:case"end":return t.stop()}}),t)})))()}}};t.default=c}).call(this,i("543d")["default"])}},[["2ebc","common/runtime","common/vendor"]]]);