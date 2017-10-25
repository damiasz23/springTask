<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ attribute name="task" type="com.sda.demo.tasks.model.Task" required="true" %>

<tr>
    <th scope="row">${task.id}</th>
    <td>${task.name}</td>
    <td>${task.comment}</td>
    <td></td>
</tr>