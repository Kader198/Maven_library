<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Livre" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>Library</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body>
<%--    <jsp:include page="common/header.jsp" />--%>
    <div class="row row-cols-auto">
        <jsp:include page="../common/sidebar.jsp"/>
        <section class="col-9 w-75 ">
            <jsp:include page="../common/navbar.jsp"/>
            <h3>Les livres</h3>
            <button class="btn btn-primary p-1 btnright m-2" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                Ajouter un livre
            </button>

            <table class="table w-100">
                <thead class="table-dark">
                    <tr class="text-center">
                        <td>id</td>
                        <td>Nom</td>
                        <td>Sidi</td>
                        <td>Actions</td>
                    </tr>
                </thead>
                <tbody>
                    <h2>les choses se passent de la meilleure facon</h2>
                    <c:forEach items="${livres}" var="livre">
                        <tr class="text-center">
                            <td><c:out value="${livre.libelle}"/></td>
                            <td><c:out value="${livre.cout}"/></td>
                            <td><c:out value="${livre.id}"/></td>
                            <td>
                                <button class="btn btn-dark">voir</button>
                                <button class="btn btn-danger">Supprimer</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
    </div>

<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="LivreServlet" method="post" >
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="row">
                        <div class="form-group col-md-12">
                            <label>Libelle</label>
                            <input type="text" name="libelle" placeholder="Le libelle du livre" class="form-control"/>
                        </div>
                        <div class="form-group col-md-12">
                            <label> Cout</label>
                            <input type="number" name="cout" placeholder="Le cout du livre" class="form-control"/>
                        </div>
                        <div class="form-group col-md-12">
                            <label>Auteur</label>
                            <input type="number" name="auteur" placeholder="L' auteur du livre" class="form-control"/>
                        </div>
                        <div class="form-group">

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
