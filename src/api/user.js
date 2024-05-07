import request from "@/utils/axios"
export default{
    login(userInfo)
    {
        return request({
            url:'/user/login',
            method:'post',
            params:userInfo
        })
    },
    register(userInfo)
    {
        return request({
            url:'/user/register',
            method:'post',
            params:userInfo
        })
    },
    modify(userInfo)
    {
        return request({
            url:'/user/modify',
            method:'post',
            params:userInfo
        })
    }
}