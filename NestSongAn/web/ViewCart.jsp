<%-- 
    Document   : ViewCart
    Created on : Oct 30, 2022, 3:04:21 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.HashMap"%>
<%@page import="ductm.category.Item"%>
<%@page import="java.util.List"%>
<%@page import="ductm.category.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Cart</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            HashMap<Integer, Item> cart = (HashMap<Integer, Item>) session.getAttribute("cart");
           
            if (cart == null) {
        %>
        <h3>The Cart is Empty!</h3>
        <%
        } else {
            if (cart.size() > 0) {
        %>
        <jsp:include page="Menu.jsp"></jsp:include>
          <div class="container">
            <div class="row">
                <jsp:include page="Left.jsp"></jsp:include>

                    <div class="col-sm-9">
                        <div class="row">
                        <div class="container">
                            <div class="card">
                                <div class="row">
                                    <div class="container">
                                        <div class="row">

                                            <div class="col-sm-9"></div>
                                            <div class="table-responsive">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th scope="col" class="border-0 bg-light">
                                                                <div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
                                                            </th>
                                                            <th scope="col" class="border-0 bg-light">
                                                                <div class="py-2 text-uppercase">Đơn Giá</div>
                                                            </th>
                                                            <th scope="col" class="border-0 bg-light">
                                                                <div class="py-2 text-uppercase">Số Lượng</div>
                                                            </th>
                                                            <th scope="col" class="border-0 bg-light">
                                                                <div class="py-2 text-uppercase">Xóa</div>
                                                            </th>
                                                            <th scope="col" class="border-0 bg-light">
                                                                <div class="py-2 text-uppercase">Cập Nhật</div>
                                                            </th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                    <%
                                                        for (Item item : cart.values()) {
                                                    %>

                                                    <tr>
                                                <form action="CartController" method="POST">

                                                    <td><div class="ml-3 d-inline-block align-middle">
                                                            <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block"><%= item.getName()%></a></h5><span class="text-muted font-weight-normal font-italic"></span>
                                                        </div>
                                                    </td>

                                                    <td class="align-middle"><strong><%=item.getProduct().getPrice()%></strong></td>


                                                    <td><strong><input name="quantity" type="number" value="<%= item.getQuantity()%>" required=""></td></strong>
                                                        <input name="id" type="hidden" value="<%=item.getID()%>">
                                                    <td class="align-middle"><a href="#" class="text-dark">
                                                            <button name="op" value="Delete" type="submit" class="btn btn-link">Delete</button>
                                                        </a>
                                                    </td>
                                                    <td class="align-middle"><a href="#" class="text-dark">
                                                            <button name="op" value="Update" type="submit" class="btn btn-link">Update</button>
                                                        </a>
                                                    </td>


                                                </form>
                                                </tr>

                                                <%
                                                    }
                                                %>
                                                </tbody>
                                            </table>
                                            <%
                                                    }
                                                }
                                            %>
                                           </div>
                        </div>

                        <div class="row py-5 p-4 bg-white rounded shadow-sm">
                            <div class="col-lg-6">
                               
                                <div class="p-4">
                                   
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>
                                <div class="p-4">
                                    <ul class="list-unstyled mb-4">
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng tiền hàng</strong><strong>
                                                <c:out value="${sessionScope.total}$" />
                                                </strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Phí vận chuyển</strong><strong>Free ship</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">VAT</strong><strong><c:out value="${sessionScope.total*10/100}$ " /></strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng thanh toán</strong>
                                            <h5 class="font-weight-bold"> <c:out value="${sessionScope.total+sessionScope.total*10/100}" /> $</h5>
                                        </li>
                                    </ul><a href="CartController?op=Checkout" class="btn btn-dark rounded-pill py-2 btn-block">Mua hàng</a>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>

</html>
</html>