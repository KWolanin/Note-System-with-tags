function currentTime() {
    let date = new Date();
    let hh = date.getHours();
    let mm = date.getMinutes();
    let ss = date.getSeconds();

    hh = (hh < 10) ? "0" + hh : hh;
    mm = (mm < 10) ? "0" + mm : mm;
    ss = (ss < 10) ? "0" + ss : ss;

    let time = hh + ":" + mm + ":" + ss;
    document.querySelector(".clock").innerText = time;
    let t = setTimeout(function () {
        currentTime()
    }, 1000);

}
    currentTime();

    let clearButton = document.querySelector("#clearTagsButton");

function showThisTag(a){
    const color =  "#" + Math.random().toString(16).substr(2,6);
    let tagName = a.innerText;
    let noteList = document.querySelectorAll(".singleNote");
    for (const noteListElement of noteList) {
        let tagCollection = noteListElement.querySelectorAll(".tags");
        for (const tagCollectionElement of tagCollection) {
            let tag = tagCollectionElement.innerText;
            if (tagName === tag){
                noteListElement.style.backgroundColor = color;
            }
        }
    }
}

function clearTags(){
    let noteList = document.querySelectorAll(".singleNote");
    for (const noteListElement of noteList) {
        noteListElement.style.backgroundColor = "";
    }
    let clearButton = document.querySelector("#clearTagsButton");
}

let noteForm = document.querySelector("#noteForm");

function toggleForm(){
  if (window.getComputedStyle(noteForm).display == "none"){
    noteForm.style.display = "table-caption";
  } else {
    noteForm.style.display = "none";
  }
}
