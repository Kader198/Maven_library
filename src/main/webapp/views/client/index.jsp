<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Auteur" %>
<%@ page import="entity.Client" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>Library</title>
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
  <script src="../../js/script.js"></script>
</head>
<body>
<%--    <jsp:include page="common/header.jsp" />--%>
<div class="row row-cols-auto">
  <jsp:include page="../../common/sidebar.jsp"/>
  <section class="col-9 w-75 ">
    <jsp:include page="../../common/navbar.jsp"/>
    <h3>Les clients </h3>
    <button class="btn btn-primary p-1 float-end btnright m-2" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
      Ajouter un client
    </button>
    <%
      if (request.getAttribute("success") != null)
      {
    %>
    <div class="alert alert-success p-2 text-center">
      <%= request.getAttribute("success") %>
    </div>
    <%
      }
    %>
    <table class="table w-100">
      <thead class="table-dark">
      <tr class="text-center">
        <td>id</td>
        <td>Nom</td>
        <td>Prenom</td>
        <td>Age </td>
        <td>Actions</td>
      </tr>
      </thead>
      <tbody>
      <% if (request.getAttribute("clients") != null) { %>
      <% List<Client> clients = (List) request.getAttribute("clients"); %>
      <% for (Client client : clients) { %>
      <tr class="text-center">
        <td ><%= client.getId() %></td>
        <td ><%= client.getNom() %></td>
        <td ><%= client.getPrenom() %></td>
        <td ><%= client.getAge() %></td>
        <td>
          <a href="editClient?id=<%= client.getId() %>" class="btn btn-dark" >voir</a>
          <a href="deleteClient?id=<%= client.getId() %>" class="btn btn-danger">Supprimer</a>
        </td>
      </tr>
      <% } %>
      <% } %>
      </tbody>
    </table>
  </section>
</div>

<!-- Modal Add-->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <form action="clients" method="post">
        <div class="modal-header">
          <h5 class="modal-title" id="staticBackdropLabel">Ajouter un auteur </h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="row">
            <div class="form-group col-md-12">
              <label>Nom</label>
              <input type="text"  name="nom" placeholder="le nom ddu client " class="form-control"/>
            </div>
            <div class="form-group col-md-12">
              <label>Prenom</label>
              <input type="text"  name="prenom" placeholder="le prenom du client  " class="form-control"/>
            </div>
            <div class="form-group col-md-12">
              <label>Age</label>
              <input type="text"  name="age" placeholder="l'age du client " class="form-control"/>
            </div>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary float-right">Sauvegarder</button>
        </div>
      </form>

    </div>
  </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
<script src="../js/bootstrap.bundle.js"></script>
<script >
  $(document).ready( function () {
    $('#livres_table').DataTable();
  } );
</script>
</body>
</html>

