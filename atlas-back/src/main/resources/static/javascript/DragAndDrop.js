const dropBox = document.querySelector('.drag-drop-box');

dropBox.addEventListener('dragover', e => {
    e.preventDefault();
    dropBox.classList.add('dragging');
});

dropBox.addEventListener('dragleave', e => {
    dropBox.classList.remove('dragging');
});

dropBox.addEventListener('drop', e => {
    e.preventDefault();
    dropBox.classList.remove('dragging');

    const files = Array.from(e.dataTransfer.files);
    files.forEach(uploadFile);
});

function uploadFile(file) {
    const formData = new FormData();
    formData.append('file', file);

    fetch('/upload', {
        method: 'POST',
        body: formData
    })
    .then(response => {
        console.log(response);
    })
    .catch(error => {
        console.error(error);
    });
}

