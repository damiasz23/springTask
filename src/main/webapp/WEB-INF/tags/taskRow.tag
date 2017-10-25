<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ attribute name="task" type="com.sda.demo.tasks.model.Task" required="true" %>
<%@ attribute name="id" type="java.lang.Integer" required="true" %>

<tr>
    <th scope="row">${id}</th>
    <td>${task.name}</td>
    <td>${task.comment}</td>
    <td>
        <a hrev="details?id=${task.id}" >
            <button type="button" class="btn btn-default">Details</button>
        </a>
        <a hrev="edit?id=${task.id}" >
            <button type="button" class="btn btn-info">Edit</button>
        </a>
        <a hrev="delete?id=${task.id}" >
            <button type="button" class="btn btn-danger">Delete</button>
        </a>
    </td>
</tr>