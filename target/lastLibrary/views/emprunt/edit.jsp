<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Livre" %>
<%@ page import="entity.Client" %>
<%@ page import="entity.Emprunt" %>
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
        <h3>Modifier l'emprunt </h3>
        <%
            if (request.getAttribute("success") != null)
            {
        %>
        <div class="alert alert-success p-2">
            <%= request.getAttribute("success") %>
        </div>
        <%
            }
        %>
        <% Emprunt emprunt = (Emprunt) request.getAttribute("emprunt"); %>
        <form action="editEmprunt" method="post">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Editer l' emprunt </h5>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="form-group col-md-12">
                        <label>Date emprunt </label>
                        <input type="date"  name="dateDebut"  value="<%= emprunt.getDateEmprunt() %>" class="form-control"/>
                    </div>
                    <div class="form-group col-md-12">
                        <label>Date retour </label>
                        <input type="date"  name="dateFin" value="<%= emprunt.getDateRetour() %>" class="form-control"/>
                    </div>
                    <div class="form-group col-md-12">
                        <label>Prix emprunt</label>
                        <input type="number"  name="prix"  value="<%= emprunt.getPrix() %>" class="form-control"/>
                    </div>
                    <div class="form-group col-md-12">
                        <label>Quantité</label>
                        <input type="number"  name="qte"  value="<%= emprunt.getQte() %>" class="form-control"/>
                    </div>
                    <div class="form-group col-md-12">
                        <label>Etat</label>
                        <select class="form-select" name="etat">
                            <option value="0">Emprunter</option>
                            <option value="1">Remis</option>
                        </select>
                    </div>
                    <div class="form-group col-md-12">
                        <label>Client</label>
                        <select class="form-control form-select " name="client_id">
                            <% if (request.getAttribute("emprunts") != null) { %>
                            <% List<Emprunt> emprunts = (List) request.getAttribute("emprunts"); %>
                            <% List<Client> clients = (List) request.getAttribute("clients"); %>
                            <% for (Client  client: clients) { %>
                                <% if (emprunt.getClient().getId() == emprunt.getClient().getId()){ %>
                                    <option value="<%= client.getId() %>" selected><%= client.getNom() %></option>
                                    <% }else{ %>
                                    <option value="<%= client.getId() %>"><%= client.getNom() %></option>
                                <% } %>
                            <% } %>
                            <% } %>
                        </select>
                        <input type="hidden" name="id"  value="<%= emprunt.getId() %>"/>
                    </div>
                    <div class="form-group col-md-12">
                        <label>Livre</label>
                        <select class="form-control form-select " name="livre_id">
                            <% if (request.getAttribute("emprunts") != null) { %>
                            <% List<Livre> livres = (List) request.getAttribute("livres"); %>
                            <% for (Livre  livre: livres) { %>
                                <% if (emprunt.getLivre().getId() == livre.getId()){ %>
                                    <option value="<%= livre.getId() %>" selected><%= livre.getLibelle() %></option>
                                    <% }else{ %>
                                    <option value="<%= livre.getId() %>"><%= livre.getLibelle() %></option>
                                <% } %>
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

    </section>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="../js/bootstrap.bundle.js"></script>
</body>
</html>
