import Vue from 'vue'
import VueRouter from 'vue-router'
import UserList from '@/views/UserList.vue'
import UserEdit from '@/views/UserEdit.vue'

Vue.use(VueRouter)

const routes = [
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
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
