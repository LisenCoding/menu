
import uniBadge from './uni-badge/uni-badge.vue'
import uniCalendar from './uni-calendar/uni-calendar.vue'
import uniCard from './uni-card/uni-card.vue'
import uniCollapseItem from './uni-collapse-item/uni-collapse-item.vue'
import uniCollapse from './uni-collapse/uni-collapse.vue'
import uniCountdown from './uni-countdown/uni-countdown.vue'
import uniDrawer from './uni-drawer/uni-drawer.vue'
import uniFab from './uni-fab/uni-fab.vue'
import uniFav from './uni-fav/uni-fav.vue'
import uniGoodsNav from './uni-goods-nav/uni-goods-nav.vue'
import uniGridItem from './uni-grid-item/uni-grid-item.vue'
import uniGrid from './uni-grid/uni-grid.vue'
import uniIcons from './uni-icons/uni-icons.vue'
import uniIndexedList from './uni-indexed-list/uni-indexed-list.vue'
import uniListItem from './uni-list-item/uni-list-item.vue'
import uniList from './uni-list/uni-list.vue'
import uniLoadMore from './uni-load-more/uni-load-more.vue'
import uniNavBar from './uni-nav-bar/uni-nav-bar.vue'
import uniNoticeBar from './uni-notice-bar/uni-notice-bar.vue'
import uniNumberBox from './uni-number-box/uni-number-box.vue'
import uniPagination from './uni-pagination/uni-pagination.vue'
import uniPopup from './uni-popup/uni-popup.vue'
import uniRate from './uni-rate/uni-rate.vue'
import uniSearchBar from './uni-search-bar/uni-search-bar.vue'
import uniSection from './uni-section/uni-section.vue'
import uniSegmentedControl from './uni-segmented-control/uni-segmented-control.vue'
import uniStatusBar from './uni-status-bar/uni-status-bar.vue'
import uniSteps from './uni-steps/uni-steps.vue'
import uniSwipeAction from './uni-swipe-action/uni-swipe-action.vue'
import uniSwiperDot from './uni-swiper-dot/uni-swiper-dot.vue'
import uniTag from './uni-tag/uni-tag.vue'
export {
  uniBadge,
  uniCalendar,
  uniCard,
  uniCollapseItem,
  uniCollapse,
  uniCountdown,
  uniDrawer,
  uniFab,
  uniFav,
  uniGoodsNav,
  uniGridItem,
  uniGrid,
  uniIcons,
  uniIndexedList,
  uniListItem,
  uniList,
  uniLoadMore,
  uniNavBar,
  uniNoticeBar,
  uniNumberBox,
  uniPagination,
  uniPopup,
  uniRate,
  uniSearchBar,
  uniSection,
  uniSegmentedControl,
  uniStatusBar,
  uniSteps,
  uniSwipeAction,
  uniSwiperDot,
  uniTag
}
const install = function(Vue, options) {
  const components = require.context('./', true, /.vue$/)
  components.keys().forEach(fileName => {
    const componentConfig = components(fileName)['default']
    Vue.component(componentConfig.name, componentConfig)
  })
}
export default install
