function openEditModalBook(){
    const libelle = document.getElementById("lib");
    const cout = document.getElementById("cout");
    const auteur = document.getElementById("auteur");
    console.log(libelle.textContent,cout.textContent,auteur.innerText);
    document.getElementById("editLibelle").textContent = libelle.textContent;
    document.getElementById("editCout").innerText = cout.innerText;
    document.getElementById("editAuteur").innerText = auteur.innerText;
}