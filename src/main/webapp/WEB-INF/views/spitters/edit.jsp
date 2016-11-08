<%--
  Created by IntelliJ IDEA.
  User: Tau_Hsu
  Date: 2016/10/12
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<style>
    .error {
        color: #ff0000;
        font-style: italic;
    }
</style>

<div>
    <h2>Create a free Spitter Account</h2>
    <h3> <sf:errors path="*" cssClass="error"/></h3><%--显示所有错误信息--%>
    <%--sf:form 标签将creatSpitterProfile()方法所放入模型的Spitter对象（通过modelAttribute="spitter"）绑定到表单的各个输入域
    POST 表明以POST请求方式进行提交，但没有指定URL，他将被提交到/spitter,即展现表单的URL--%>
    <%--enctype属性定义上传表单的数据格式默认application/x-www-form-urlencoded,数据格式key-valued的形式，但对于文件就没法处理
    ，因此可以使用multipart/form-data--%>
    <sf:form method="POST" modelAttribute="spitter" enctype="multipart/form-data"><%--将表单绑定的模型属性--%>
        <fieldset>
            <table cellspacing="0">
                <tr>
                    <th><label for="user_full_name">Full Name:</label></th>
                    <%--sf:input sf:password sf:checkbox标签都有一个path属性，他的引用的是表单所绑定的Spitter的属性
                    当提交表单时，这些输入域的值将会放到Spitter对象中提交到服务器进行处理
                    --%>
                    <td><sf:input path="fullName" size="15" id="user_full_name"/>
                        <%--<sf:errors path="fullName" cssClass="error" delimiter=", "/>使用逗号和空格分割错误信息--%>
                        <br/>
                        <sf:errors path="fullName" cssClass="error"/><%--显示错误--%>
                    </td>
                </tr>

                <tr>
                    <th><label for="user_screen_name">Username:</label></th>
                    <td><sf:input path="username" size="15" maxlength="15" id="user_screen_name"/><%--用户名输入域--%>
                        <small id="username_msg">No spaces, please.</small>
                        <br/>
                        <sf:errors path="username" cssClass="error"/>
                    </td>
                </tr>

                <tr>
                    <th><label for="user_password">Password:</label></th>
                    <td><sf:password path="password" size="30" showPassword="true" id="user_password"/><%--密码输入域--%>
                        <small>6 characters or more (be tricky!)</small>
                        <br/>
                        <sf:errors path="password" cssClass="error"/>
                    </td>
                </tr>

                <tr>
                    <th><label for="user_email">Email Address:</label></th>
                    <td><sf:input path="email" size="30" id="user_email"/><%--Email输入域--%>
                        <small>In case you forget something.</small>
                        <br/>
                        <sf:errors path="email" cssClass="error"/>
                    </td>
                </tr>

                <tr>
                    <th></th>
                    <td>
                        <sf:checkbox path="updateByEmail" id="user_send_email_newsletter"/>
                        <label for="user_send_email_newsletter">Send me email updates!</label><%--通过电子邮件更新的复选框--%>
                    </td>
                </tr>

                <tr>
                    <th><label for="image" >Profile image: </label></th>
                    <td><input name="image" type="file" id="image"/></td><%--文件上传标签，标准的HTML标签，大多数浏览器都会将其展示为一个按钮和一个文本域,name属性一定要求有，POST请求后会匹配这个属性--%>
                </tr>

                <tr>
                    <th></th>
                    <td>
                        <input name="commit" type="submit" value="I accept. Create my account.">
                    </td>
                </tr>
            </table>
        </fieldset>
    </sf:form>
    <jsp:include page="buttonLogout.jsp"/>
</div>
