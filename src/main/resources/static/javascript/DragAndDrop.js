var dropzone = document.getElementById('drag-drop-box');

dropzone.addEventListener('dragover', function(event) {
  event.preventDefault();
  dropzone.style.border = '2px dashed #333';
});

dropzone.addEventListener('dragleave', function(event) {
  event.preventDefault();
  dropzone.style.border = '2px dashed #aaa';
});

dropzone.addEventListener('drop', function(event) {
  event.preventDefault();
  dropzone.style.border = '2px dashed #aaa';
  
  var files = event.dataTransfer.files;
  var formData = new FormData();
  formData.append('file', files[0]);
  
  var xhr = new XMLHttpRequest();
  xhr.open('POST', '/upload', true);
  xhr.onload = function() {
    console.log(this.responseText);
  };
  xhr.send(formData);
});
