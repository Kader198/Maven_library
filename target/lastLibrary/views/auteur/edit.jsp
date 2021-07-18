<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Livre" %>
<%@ page import="entity.Auteur" %>
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
        <h3>Les auteurs</h3>
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
        <% Auteur auteur = (Auteur) request.getAttribute("auteur"); %>
        <form action="editAuteur" method="post">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Editer le auteur </h5>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="form-group col-md-12">
                        <label>Libelle</label>
                        <input type="text" id="nom" value="<%= auteur.getNom() %>" name="nom" placeholder="Le nom du l'auteur " class="form-control"/>
                        <input type="hidden" name="id" value="<%= auteur.getId() %>"/>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary float-right">Sauvegarder</button>
            </div>
            <select class="form-control form-select " name="auteur_id" multiple aria-label="multiple select example">
                <% if (auteur.getLivres() != null && request.getAttribute("auteurs") != null) { %>
                    <% for (Livre livre : auteur.getLivres()) { %>
                            <% if(livre.getAuteur().getId() == auteur.getId()) { %>
                                <option value="<%= livre.getId() %>" selected><%= livre.getLibelle() %></option>
                            <% }else { %>
                                <option value="<%= livre.getId() %>" ><%= livre.getLibelle() %></option>
                            <% } %>
                    <% } %>
                <% } %>
            </select>
        </form>

    </section>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="../js/bootstrap.bundle.js"></script>
</body>
</html>
