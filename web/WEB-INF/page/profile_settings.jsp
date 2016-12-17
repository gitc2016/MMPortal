<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: levon
  Date: 12/12/16
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-sm-2">
</div>
<div class="col-sm-8">

<h1>Your profile information</h1>

<hr/>


<form  action="updateProfile.action" id="" autocomplete="on" method="post">

    <div class="col-md-6">
        <div class="form-group ">
            <s:textfield name="user.name" value="%{user.name}" placeholder="First name" cssClass="form-control" maxLength="50"/>
        </div>
    </div>
    <div class="col-md-6">
        <div class="form-group ">
            <s:textfield name="user.surname" value="%{user.surname}" placeholder="Last name" cssClass="form-control" maxLength="50"/>
        </div>
    </div>

    <div class="form-group ">
        <h4>Profile photo</h4>
        <s:file name="photo" cssClass="form-control"/>
    </div>

    <div class="form-group ">
        <s:textfield name="user.email" value="%{user.email}" placeholder="Email" cssClass="form-control" maxLength="255"/>
    </div>

    <div class="form-group ">
        <s:password name="user.password"  value="%{user.password}" placeholder="Current Password" cssClass="form-control"/>
    </div>

    <div class="form-group ">
        <s:textfield name="newPassword"  placeholder="New Password" cssClass="form-control"/>
    </div>

    <div class="form-group ">
        <s:textfield name="user.confirmPassword"  placeholder="Confirm Password" cssClass="form-control"/>
    </div>

    <s:select key="country"
              list="%{#application.country}"
              listKey="id"
              listValue="name"
              name="ids"/>

    <s:textfield id="datepicker" key="birthDate" name="user.birthDate"/>



    <div class="submit">
        <s:submit name="password" cssClass="btn btn-primary btn-lg"/>
    </div>
</form>
</div>

<div class="col-sm-2">
</div>
