$(document).ready(function() {

    let canvas = new fabric.Canvas('paint-canvas');
    // let symbolCanvas = new fabric.Canvas('symbolCanvas');
    canvas.isDrawingMode = true;
    canvas.freeDrawingBrush.width = 10;
    canvas.freeDrawingBrush.color = "black";

    $('#clear').on('click', function () {
        canvas.clear();
    })

    $('#save').on('click', function() {
        let imageName = prompt('Please enter image name');
        let canvasDataURL = canvas.toDataURL();
        let a = document.createElement('a');
        a.href = canvasDataURL;
        a.download = imageName || 'drawing';
        a.click();
    })

    $('#drawingMode').on('click', function() {
            canvas.isDrawingMode = !canvas.isDrawingMode;
            if (canvas.isDrawingMode) {

                $(this).text('Format');
            }
            else {
                $(this).text('Draw');
            }
        });

    $('#drawingLineWidth').change(function() {
        canvas.freeDrawingBrush.width = parseInt($(this).val()) || 1;
        $('#rangeValue').text($(this).val());
    })

    $(document).keyup(function(e){
        if(e.keyCode === 46) {
            canvas.getActiveObjects().forEach((obj) => {
                canvas.remove(obj)
            });
            canvas.discardActiveObject().renderAll()
        }
    });

    $('#deleteObject').on('click', function(){
        canvas.getActiveObjects().forEach((obj) => {
            canvas.remove(obj)
        });
        canvas.discardActiveObject().renderAll()
    });

    $('#symbolModal').on('hidden.bs.modal', function () {
        canvas.clear();
        resetOptions();
    });

    $('#saveSymbolModal').on('click', function() {
        // let sourceCanvas = document.getElementById('paint-canvas');
        // let symbolCanvasContext = symbolCanvas.getContext('2d');
        // symbolCanvasContext.clearRect(0, 0, symbolCanvas.width, symbolCanvas.height);
        // symbolCanvasContext.drawImage(sourceCanvas, 0, 0, 200, 200);
        // console.log($('#symbolCanvas').attr('src'));
        // $('#symbolCanvas').attr('src', canvas.toDataURL());
        $('#figureDiv').html(`<img id="symbolPicture" src=${canvas.toDataURL()} alt="Symbol figure" width="200" height="200"/>`)
    });

    function resetOptions() {
        canvas.isDrawingMode = true;
        canvas.freeDrawingBrush.width = 10;
        $('#drawingMode').text('Format');
        $('#rangeValue').text('10');
        $('#drawingLineWidth').val('10');
    }
});