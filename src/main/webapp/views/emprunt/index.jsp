<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Client" %>
<%@ page import="entity.Livre" %>
<%@ page import="entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>Library</title>
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
        <h3>Les emprunts</h3>
        <button class="btn btn-primary p-1 float-end btnright m-2" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
            Ajouter un auteur
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
                <td>Actions</td>
            </tr>
            </thead>
            <tbody>
            <% if (request.getAttribute("emprunts") != null) { %>
            <% List<Emprunt> emprunts = (List) request.getAttribute("emprunts"); %>
            <% for (Emprunt emprunt : emprunts) { %>
            <tr class="text-center">
                <td ><%= emprunt.getId() %></td>
                <td ><%= emprunt.getDateEmprunt() %></td>
                <td ><%= emprunt.getDateRetour() %></td>
                <td>
                    <a href="editEmprunt?id=<%= emprunt.getId() %>" class="btn btn-dark" >voir</a>
                    <a href="deleteEmprunt?id=<%= emprunt.getId() %>" class="btn btn-danger">Supprimer</a>
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
                            <label>Date emprunt </label>
                            <input type="date"  name="dateDebut"  class="form-control"/>
                        </div>
                        <div class="form-group col-md-12">
                            <label>Date retour </label>
                            <input type="date"  name="dateFin"  class="form-control"/>
                        </div>
                        <div class="form-group col-md-12">
                            <label>Prix emprunt</label>
                            <input type="text"  name="nom"  class="form-control"/>
                        </div>
                        <div class="form-group col-md-12">
                            <label>Client</label>
                            <select class="form-control form-select " name="auteur_id">
                                <% if (request.getAttribute("clients") != null) { %>
                                <% List<Client> clients = (List) request.getAttribute("clients"); %>
                                    <% for (Client client : clients) { %>
                                        <option value="<%= client.getId() %>" selected><%= client.getNom() %></option>
                                    <% } %>
                                <% } %>
                            </select>
                        </div>
                        <div class="form-group col-md-12">
                            <label>Age</label>
                            <label>Client</label>
                            <select class="form-control form-select " name="auteur_id">
                                <% if (request.getAttribute("clients") != null) { %>
                                    <% List<Livre> livres = (List) request.getAttribute("livres"); %>
                                    <% for (Livre livre : livres) { %>
                                        <option value="<%= livre.getId() %>" selected><%= livre.getLibelle() %></option>
                                    <% } %>
                                <% } %>
                            </select>
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

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="../js/bootstrap.bundle.js"></script>
</body>
</html>

