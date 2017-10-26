<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="common/header.jsp"/>

<body>

<jsp:include page="common/nav.jsp"/>

<div class="container">

    <div class="row" style="padding-top: 100px">
        <div class="col-md-12">
            <h1>
                <div class="form-group row">
                    <label for="example-name-input" class="col-2 col-form-label">Name</label>
                    <div class="col-10">
                        <input class="form-control" type="text" value="Artisanal kale" id="example-name-input">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="example-comment-input" class="col-2 col-form-label">Comment</label>
                    <div class="col-10">
                        <input class="form-control" type="text" value="Artisanal kale" id="example-comment-input">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="example-priority-input" class="col-2 col-form-label">Priority</label>
                    <div class="col-10">
                        <input class="form-control" type="text" value="Artisanal kale" id="example-priority-input">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="example-deadline-input" class="col-2 col-form-label">Deadline</label>
                    <div class="col-10">
                        <input class="form-control" type="datetime-local" value="2011-08-19T13:45:00" id="example-deadline-input">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="example-dateCreated-input" class="col-2 col-form-label">Date Created</label>
                    <div class="col-10">
                        <input class="form-control" type="datetime-local" value="2011-08-19T13:45:00" id="example-dateCreated-input">
                    </div>
                </div>
                <c:choose>
                    <c:when test="${empty task.id}">
                        Add new task
                    </c:when>
                    <c:otherwise>
                        Edit task
                    </c:otherwise>
                </c:choose>
            </h1>
            <form:form method="POST" action="/add" modelAttribute="task">
                <form:hidden path="id" />
                <table>
                    <tr>
                        <td><form:label path="name">Name</form:label></td>
                        <td><form:input path="name"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="comment">Comment</form:label></td>
                        <td><form:input path="comment"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="priority">Priority</form:label></td>
                        <td><form:input path="priority"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="deadline">Deadline</form:label></td>
                        <td><form:input path="deadline"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="dateCreated">Date Created</form:label></td>
                        <td><form:input path="dateCreated"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Save"></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</div>
</body>
