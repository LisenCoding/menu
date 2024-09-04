<template>
	<view>
		<view class="article-meta">
			<user-reply v-if="newData.childs" :digest="newData.childs"></user-reply>
			<view class="article-meta-box">
				<!-- <view class="article-header-image">
					<view class="article-header-title"><text class="article-header-title-text">{{ digestData.length + 1}}</text>
					</view>
				</view> -->
				<view style="width:100%">
					<view class="article-header-content">
						<view class="article-header-title">
							用户:{{newData.username}}
						</view>
						<view class="article-header-info">{{newData.addtime||''}}</view>
					</view>
					<view class="uni-article__comment-centent">
						{{newData.content}}
						<text class="btn-replay" @tap="onReplyTap(newData.id)" >回复</text>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import userReply from '@/components/forum-reply/forum-reply.vue'
	export default {
		name: 'userReply',
		components: {
			userReply
		},
		props: {
			digest: {
				type: Array,
				default () {
					return {}
				}
			}
		},
		data() {
			return {
				newData: {},
				digestData: [],
				UNITS: {
					'年': 31557600000,
					'月': 2629800000,
					'天': 86400000,
					'小时': 3600000,
					'分钟': 60000,
					'秒': 1000
				}
			}
		},
		created() {
			this.digest.forEach((vm, index) => {
				console.log(vm,index)
				if (index === 0) {
					this.newData = vm;
					// this.newData.pubDate = this.format(vm.pubDate);
				} else {
					this.digestData.push(vm);
				}
			})
		},
		methods: {
			format(dateStr) {
				var date = this.parse(dateStr)
				var diff = Date.now() - date.getTime();
				if (diff < this.UNITS['天']) {
					return this.humanize(diff);
				}
				var _format = function(number) {
					return (number < 10 ? ('0' + number) : number);
				};
				return date.getFullYear() + '-' + _format(date.getMonth() + 1) + '-' + _format(date.getDate()) + ' ' +
					_format(date.getHours()) + ':' + _format(date.getMinutes());
			},
			humanize(milliseconds) {
				var humanize = '';
				for (var key in this.UNITS) {
					if (milliseconds >= this.UNITS[key]) {
						humanize = Math.floor(milliseconds / this.UNITS[key]) + key + '前';
						break;
					}
				}
				return humanize || '刚刚';
			},
			//将"yyyy-mm-dd HH:MM:ss"格式的字符串，转化为一个Date对象
			parse(str) {
				var a = str.split(/[^0-9]/);
				return new Date(a[0], a[1] - 1, a[2], a[3], a[4], a[5]);
			},
			onReplyTap(pid){
				this.$utils.jump(`../forum-reply/forum-reply?pid=${pid}`);
			}
		}
	}
</script>

<style scoped>
	.article-meta {
		display: flex;
		/* align-items: center; */
		flex-direction: column;
		background: #fdfdfd;
		border: 1px #ddd solid;
		border-radius: 10rpx;
		margin-bottom: 20rpx;
		padding: 5rpx;
	}

	.article-meta-box {
		padding-top: 20rpx;
		padding-left: 10rpx;
		padding-bottom: 0;
		display: flex;
		/* align-items: center; */
		justify-content: flex-start;
		color: gray;

	}

	.article-header-image {
		flex-shrink: 0;
		width: 40rpx;
		overflow: hidden;
	}

	.article-header-content {
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		font-size: 24rpx;
		line-height: 1;
		/* width: 100%; */
		padding-right: 20rpx;
		/* height: 60rpx; */
	}

	.article-header-title {
		display: flex;
		justify-content: space-between;
		align-items: center;
		font-size: 26rpx;
		line-height: 1;
		color: #000;
	}

	.article-header-title-text {
		line-height: 1.2;
	}

	.article-top {
		display: flex;
		align-items: flex-end;
		font-size: 26rpx;
		color: #999;
		line-height: 1;
	}

	.article-top .image {
		width: 30rpx;
		margin-left: 5rpx;
	}

	.article-header-info {
		margin-top: 10rpx;
		font-size: 24rpx;
		line-height: 1;
	}

	.uni-article__comment-centent {
		padding: 20rpx;
		padding-left: 0;
		color: #333;
		font-size: 28rpx;
	}
	
	.btn-replay{
		color: red;
		float: right;
	}
</style>
