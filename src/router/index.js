import { createRouter, createWebHistory } from "vue-router";

import Login from "@/components/Login.vue"
import Home from "@/components/Home.vue"
import CourseInfo from "@/components/view/CourseInfo.vue"
import Main from "@/components/view/Main.vue"
import UserInfo from "@/components/view/UserInfo.vue"
const routers=[
    {
        path:'/',
        component:Login
    },
    {
        path:'/home',
        component:Home,
        redirect:'/main',
        children:[
            {path:'/main',component:Main},
            {path:'/courseInfo',component:CourseInfo},
            {path:'/userInfo',component:UserInfo}
        ]
    }
]
const router=createRouter({
    history:createWebHistory(),
    routes:routers
})

export default router;
