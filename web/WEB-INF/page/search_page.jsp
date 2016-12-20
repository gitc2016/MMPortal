<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: levon
  Date: 12/13/16
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<s:set var="map" value="%{#application.category}"/>
<s:if test="%{searchStatus}">
    <h4>SEARCH MENTOR</h4>
</s:if>
<s:elseif test="%{!searchStatus}">
    <h4>SEARCH MENTEE</h4>
</s:elseif>
<div id="search-container" class="container">
    <div class="panel">
        <div class="panel-body">

            <div class="row">

                <div class="col-sm-6 col-md-3">
                    <select id="parentCategory" name="category" class="form-control " size="1" style="height:36px">
                        <option value="">Category</option>
                        <s:iterator value="#map" var="parent">
                            <option value="<s:property value="key"/>"><s:property value="key"/></option>
                        </s:iterator>
                    </select>
                    <form action="searchAct">
                        <s:iterator value="#map" var="parent">
                        <s:iterator value="key">
                        <select id="<s:property value="key"/>" class="categ form-control" size="1"name="categoryId"
                                style="height:36px;width: 200px ;display: none">
                            <option value="">subCategory</option>
                            <s:iterator value="value" var="subcateg">
                                <option value="#subcateg.id">
                                    <s:property value="#subcateg.name"/>
                                </option>
                            </s:iterator>
                        </select>
                        </s:iterator>
                        </s:iterator>
                </div>
                <div class="col-sm-6 col-md-3">
                    <s:textfield name="searchKeyword" placeholder="Mentor name"/>
                </div>
                <div class="col-sm-3 col-md-2">
                    <div class="submit"><input id="submit-less-options" class="btn btn-primary btn-block" type="submit" value="Filter Results"/>
                    </div>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
<%--iterator--%>
<s:iterator value="userStatusList">
    <div class="card col-sm-6 col-lg-4 ">
        <div class="mm-wgt panel panel-default with-button">
            <div class="panel-footer clearfix media">
                <div class="pull-left">
                    <a href="/members/user-profile/209306/type:mentor"
                       title="<s:property value="name"/><s:property value="surname"/>">
                        <img class="profile-pic img-circle" src="/images/MPLogo120.png"
                             alt="<s:property value="name"/>"/>
                    </a></div>
                <div class="media-body">
                    <p class="user-name">
                        <a href="/members/user-profile/209306/type:mentor"><s:property value="name"/><s:property
                                value="surname"/></a></p>


                    <p class="user-info">
                        <small>
                            <span class="glyphicon glyphicon-map-marker"></span> Washington, DC, United States<br/>
                        </small>
                        <small>
                            <span class="glyphicon glyphicon-tag" title="Industry"></span>
                            E-Commerce <br/>
                        </small>
                    </p>
                    <hr/>
                </div><!-- end .media-body -->
            </div> <!-- end dashboard's .clearfix or footer_class or .affinity-bar -->


            <div class="panel-body overflow-hidden wrapper">
                <h4>How I Can Help</h4>
                <p>
                    <small>
                        Accounting and Finance&raquo; Financial Planning
                    </small>
                </p>
                <div class="card-top-content"><p>How to create a new product, what to focus on, how to prioritize and
                    iterate on development
                    What kind of customers to address, and how to reach them. Marketing, financial, operations</p></div>
            </div> <!-- .panel-body -->
            <hr/>
            <a href="/members/user-profile/209306/type:mentor" class="btn btn-primary pull-left">Connect <span
                    class="glyphicon glyphicon-circle-arrow-right"></span></a></div>
    </div>
</s:iterator>
