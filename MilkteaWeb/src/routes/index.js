import Home from '~/component/pages/customer/home/index.js'
import Menu from '~/component/pages/customer/Menu'
import Login from "~/component/pages/login/login"
import Register from "~/component/pages/login/register"
import ForgotPassword from '~/component/pages/login/forgotpassword'
import MilkteaDetail from '~/component/pages/customer/MilkteaDetail'
import Profile from '~/component/pages/customer/profile'
import ChangePasswordPage from '~/component/pages/customer/ChangePasswordPage'
import Cart from '~/component/pages/customer/cart'
import OrderPage from '~/component/pages/customer/Order'
import OrdersOrdered from '~/component/pages/customer/OrdersOrdered'
const publicRoutes = [
    {path: '/', component: Home},
    {path: '/menu', component: Menu},
    {path: '/contact', component: Home},
    {path: '/stories', component: Home},
    {path: '/report', component: Home},
    {path: '/about', component: Home},
    {path: '/milktea/*', component: MilkteaDetail},
    {path: '/profile', component: Profile},
    {path: '/customer/cart', component: Cart},
    {path: '/customer/order', component: OrderPage},
    {path:'/ordernotincart', component: OrdersOrdered},
    {path: '/changepassword', component: ChangePasswordPage, layout:null},
    {path: '/login', component: Login, layout: null},
    {path:'/register', component: Register, layout: null},
    {path:'/forgotpassword', component:ForgotPassword,layout: null}
]

const privateRoutes = [

]

export {publicRoutes, privateRoutes}