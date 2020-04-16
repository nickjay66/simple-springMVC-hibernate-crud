<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!Doctype html>

<html>

<head>
    <title>List Customers</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button">

        <!--add out html table here -->
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Action</th>
            </tr>

            <!--Loop over and print out customers-->
            <c:forEach var="tempCustomer" items="${customers}">

                <!-- construct and "update link -->
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>

                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>
                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                    <td>${tempCustomer.phone}</td>
                    <td><a href="${updateLink}">Update</a>
                    |
                    <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete the customer?'))) return false">Delete</a>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>

</body>


</html>