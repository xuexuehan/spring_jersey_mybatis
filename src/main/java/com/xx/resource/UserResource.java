package com.xx.resource;

import com.github.pagehelper.PageInfo;
import com.xx.entity.User;
import com.xx.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("user")
public class UserResource {
    private static final Logger logger = LoggerFactory.getLogger(UserResource.class);
    @Autowired
    private UserService userService;
    /**
     * 新增用户信息数据
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response addUser(User user){
        try {
            this.userService.addUser(user);
            return Response.ok().build();
        } catch (Exception ex) {
            logger.error("addUser error, ", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    /**
     * 获取用户信息
     */
    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUser(@PathParam("id") int id){
        logger.warn(String.format("request id is %d", id));
        try {
            User user = this.userService.findById(id);
            if(user != null){
                return Response.ok(user).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception ex) {
            logger.error("getUser error, ", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }

    /**
     * 删除用户信息
     */
    @Path("/{id}")
    @DELETE
    public Response deleteUser(@PathParam("id") int id) throws Exception {
        logger.warn(String.format("request id is %d", id));
        this.userService.delUser(id);
        return Response.ok().build();
    }

    /**
     * 更新用户信息
     */
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateUser(User user) throws Exception {
        this.userService.update(user);
        return Response.ok().build();
    }

    /**
     * 查询用户列表信息
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUserList(@QueryParam("offset")int pageNum,
                                @QueryParam("limit")int pageSize,
                                @QueryParam("uname")String name,
                                @QueryParam("age")int age){
        PageInfo<User> userList = this.userService.getUserList(pageNum, pageSize, name, age);
        return Response.ok(userList).build();
    }

    @Path("/list")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUserList(){
        List<User> userList = this.userService.findAll();
        return Response.ok(userList).build();
    }
}
