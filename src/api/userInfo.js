import request from "@/utils/request.js";

export const getUserInfoServer= async()=>{
    const result= await request.get("/admin/info");
    return result;
}