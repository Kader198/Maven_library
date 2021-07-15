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
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script src="../../js/script.js"></script>
</head>
<body>
<%--    <jsp:include page="common/header.jsp" />--%>
<div class="row row-cols-auto">
    <jsp:include page="../../common/sidebar.jsp"/>
    <section class="col-9 w-75 ">
        <jsp:include page="../../common/navbar.jsp"/>
        <h3>Les livres</h3>
        <button class="btn btn-primary p-1 btnright m-2" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
            Ajouter un livre
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
        <table class="table" id="livres_table">
            <thead class="table-dark">
            <tr class="text-center">
                <th>Libelle</th>
                <th>Cout</th>
                <th>Auteur</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <% if (request.getAttribute("livres") != null) { %>
            <% List<Livre> livres = (List) request.getAttribute("livres"); %>
            <% for (Livre l : livres) { %>
            <tr class="text-center">
                <td id="lib"><%= l.getLibelle() %></td>
                <td id="cout"><%= l.getCout() %></td>
                <td id="auteur" ><%= l.getAuteur().getNom() %></td>
                <td>
                    <a href="editLivre?id=<%= l.getId() %>" class="btn btn-dark" >voir</a>
                    <a href="deleteLivre?id=<%= l.getId() %>" class="btn btn-danger">Supprimer</a>
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
            <form action="livres" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel">Ajouter un livre </h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label>Libelle</label>
                            <input type="text" id="libelle" name="libelle" placeholder="Le libelle du livre" class="form-control"/>
                        </div>
                        <div class="form-group col-md-12">
                            <label> Cout</label>
                            <input type="number"   name="cout" placeholder="Le cout du livre" class="form-control"/>
                        </div>
                        <div class="form-group col-md-12">
                            <label>Auteur</label>
                            <select class="form-control form-select " name="auteur_id">
                                <% if (request.getAttribute("auteurs") != null) { %>
                                <% List<Auteur> auteurs = (List) request.getAttribute("auteurs"); %>
                                <% for (Auteur a : auteurs) { %>
                                    <option value="<%= a.getId() %>"><%= a.getNom() %></option>
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
