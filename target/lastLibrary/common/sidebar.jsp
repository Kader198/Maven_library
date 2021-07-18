<div class="d-flex flex-column col-2 flex-shrink-0 p-3 text-white bg-dark " style="width: 23% !important;" >
    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
        <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
        <span class="fs-4 text-primary">BibTek</span>
    </a>
    <hr>
    <ul class="nav nav-pills flex-column mb-auto">
        <li class="nav-item">
            <a href="#" class="nav-link link-primary bg-light rounded-2 fw-bolder mt-3 a" aria-current="page">
                <svg class="bi me-2" width="16" height="16"><use xlink:href="#home"/></svg>
                Dashboard
            </a>
        </li>
        <li>
            <a href="livres" class="nav-link link-primary bg-light rounded-2 mt-3  text-primary fw-bolder">
                <svg class="bi me-2" width="16" height="16"><use xlink:href="#speedometer2"/></svg>
                    Gestion des livres
            </a>
        </li>
        <li>
            <a href="emprunts" class="nav-link link-primary bg-light rounded-2 mt-3  text-primary fw-bolder">
                <svg class="bi me-2" width="16" height="16"><use xlink:href="#table"/></svg>
                Gerer les emprunts
            </a>
        </li>
        <li>
            <a href="clients" class="nav-link link-primary bg-light rounded-2 mt-3  text-primary fw-bolder">
                <svg class="bi me-2" width="16" height="16"><use xlink:href="#table"/></svg>
                Gestion des clients
            </a>
        </li>
        <li>
            <a href="auteurs" class="nav-link link-primary bg-light rounded-2 mt-3  text-primary fw-bolder">
                <svg class="bi me-2" width="16" height="16"><use xlink:href="#table"/></svg>
                Gestion des auteurs
            </a>
        </li>
    </ul>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <div class="dropdown">
<%--        <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">--%>
<%--            <li><a class="dropdown-item" href="#">New project...</a></li>--%>
<%--            <li><a class="dropdown-item" href="#">Settings</a></li>--%>
<%--            <li><a class="dropdown-item" href="#">Profile</a></li>--%>
<%--            <li><hr class="dropdown-divider"></li>--%>
<%--            <li><a class="dropdown-item" href="#">Sign out</a><<script >
  btns[i].addEventListener("click", function() {
    btns[i].addEventListener("click", function() {
      </script>
<%--        </ul>--%>
    </div>
</div>
<script>
        var current = document.getElementsByClassName("active");
        var btns = btnContainer.getElementsByClassName("a");
        for (var i = 0; i < btns.length; i++) {
            btns[i].addEventListener("click", function() {
                var current = document.getElementsByClassName("active");
                current[0].className = current[0].className.replace(" active", "");
                this.className += " active";
            });
        }
</script>