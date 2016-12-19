<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: levon
  Date: 12/12/16
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>Improve your information</h1>

<hr/>
<s:set value="%{#application.category}" var="category"/>

<div class="form-group ">
    <form id="" autocomplete="on" method="post">


        <s:textarea name="description" placeholder="Describe you" cssClass="form-control"/>
</div>

<div class="form-group ">

    <s:textarea name="experience" placeholder="Experience \",\"" cssClass="form-control"/>
</div>

<div class="form-group ">
    <s:textarea name="skills" placeholder="Skills \",\"" cssClass="form-control"/>
</div>

<div class="form-group">
<select name="category" class="form-control" size="1" id="parentCategory" >
    <s:iterator value="#category" var="parent">
        <option value="<s:property value="key"/>">
            <s:property value="key"/>
        </option>
    </s:iterator>
</select>


<s:iterator value="#category" var="parent">
    <s:iterator value="key">
        <select id="<s:property value="key"/>" class="categ form-control" size="1" style="height:36px;width: 200px ;display: none; margin-left: 200px">
            <s:iterator value="value" var="subcateg">
                <option value="#subcateg">
                    <s:property value="#subcateg.name"/>
                </option>
            </s:iterator>
        </select>
    </s:iterator>
    <%--</select>--%>
</s:iterator>
</div>

<div class="submit">
    <s:submit value="Save" cssClass="btn btn-primary btn-lg"/>
</div>
</form>




