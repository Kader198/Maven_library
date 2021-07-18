<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Livre" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Tkhadjetouransitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>Library</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script src="../js/script.js"></script>
</head>
<body>
<%--    <jsp:include page="common/header.jsp" />--%>
    <div class="row row-cols-auto">
        <jsp:include page="../common/sidebar.jsp"/>
        <section class="col-9 w-75 ">
            <jsp:include page="../common/navbar.jsp"/>
            <h2 class="d-flex justify-content-center text-center text-primary fw-bolder">BibTek</h2>
            <div class="row">
                <div class="col card shadow p-4 align-content-center text-center m-3">
                    <i class="fa fa-book text fa-4x" ></i>
                </div>
                <div class="col card shadow p-4 align-content-center text-center m-3">
                    <i class="fa fa-users fa-4x" ></i>
                </div>
                <div class="col card shadow p-4 align-content-center text-center m-3">
                    <i class="fas fa-book-open fa-4x" ></i>
                </div>
                <div class="col card shadow p-4 align-content-center text-center m-3">
                    <i class="fa fa-list-alt fa-4x" ></i>
                </div>
            </div>
            <div class="row">
                <p class="text-body p-3 shadow text-center">
                    <span class="text-primary fw-bold">BibTek</span>
                    permet de d'effectuer les différentes opérations d'une bibliothéques notamment<b> l'enregistrement</b> d'un livre,<b>la modification</b>,<b>la supression</b> et la visualisation.
                    Pareil pour l'auteur ainsi établir l'opération <b>d'emprunt</b>  entre le client et le livre
                </p>
            </div>
        </section>
    </div>


<!-- Modal Add-->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="LivreController" method="post" >
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
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
                            <input type="number"  name="auteur" placeholder="L' auteur du livre" class="form-control"/>
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

<!-- Modal Edit-->
<div class="modal fade" id="editModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="editModallabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="LivreController" method="post" >
                <div class="modal-header">
                    <h5 class="modal-title" id="editModallabel">Editer le livre</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label>Libelle</label>
                            <input type="text" id="editlibelle" name="libelle" placeholder="Le libelle du livre" class="form-control"/>
                        </div>
                        <div class="form-group col-md-12">
                            <label> Cout</label>
                            <input type="number" id="editCout" name="cout" placeholder="Le cout du livre" class="form-control"/>
                        </div>
                        <div class="form-group col-md-12">
                            <label>Auteur</label>
                            <input type="number" id="editAuteur" name="auteur" placeholder="L' auteur du livre" class="form-control"/>
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap5.min.js"></script>
    <script src="../js/bootstrap.bundle.js"></script>
    <script >
        $(document).ready( function () {
            $('#livres_table').DataTable();
        } );
    </script>
</body>
</html>
