import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from '@/views/cyphers/MainView.vue'
import RecordDetailView from "@/views/cyphers/RecordDetailView.vue";
import RankingView from "@/views/cyphers/RankingView.vue"
import UserList from '@/views/UserList.vue'
import UserEdit from '@/views/UserEdit.vue'


Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Main',
        component: Main,
    },
    {
        path: '/record/detail/:nickname',
        name: 'RecordDetail',
        component: RecordDetailView,
        props: true,
    },
    {
        path: '/ranking/:type',
        name: 'Ranking',
        component: RankingView,
    },
    {
        path: '/user/list',
        name: 'UserList',
        component: UserList
    },
    {
        path: '/user/edit/:userId',
        name: 'UserEdit',
        component: UserEdit,
        props: true
    },
    {
        path: '/user/add',
        name: 'UserAdd',
        component: UserEdit
    }
]

const router = new VueRouter({
    mode: 'hash',
    base: '/vue/html',
    routes,
    scrollBehavior() {
        // 항상 페이지의 맨 위로 스크롤합니다.
        return { x: 0, y: 0 };
    }
})

export default router
