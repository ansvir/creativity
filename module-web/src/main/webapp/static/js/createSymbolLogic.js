$(document).ready(function() {
   $('#symbolCreatingBlock').hide();
    let cultures;
    $('#selectLanguage').change(function () {
        $('#culturesDetails').empty();
        $('#symbolCreatingBlock').hide();
        $('#figureDiv').empty();
        let languageId = $('#selectLanguage').val();
        if (languageId === "None") {
            $('#cultureDetails').empty();
           $('#symbolCreatingBlock').hide();
            return;
        }
        $.ajax({
            url: contextPath + '/creativity',
            data: {
                languageId: languageId,
                command: "language_editor_get_cultures"
            },
            success: function (responseText) {
                let response = JSON.parse(responseText);
                let attributes = response.attributes;
                cultures = JSON.parse(attributes.cultures);
                $('#culturesDetails').append(`
                    <div class="form-group">
                        <label for="selectCulture">Culture</label>
                            <select class="form-control" id="selectCulture" style="box-shadow: none">
                                <option>None</option>
                    `);
                $(cultures).each(function () {
                    $('#selectCulture').append($('<option>', {
                        value: this.id,
                        text: this.name
                    }));
                });
                $('#culturesDetails').append(`
                            </select>
                    </div>`);
            }
        });
    });

    $(document).on('change', '#selectCulture', function () {
       $('#symbolCreatingBlock').hide();
       $('#figureDiv').empty();
        let cultureId = $('#selectCulture').val();
        if (cultureId === 'None') {
           $('#symbolCreatingBlock').hide();
           return;
        }
        $('#cultureId').val(cultureId);
        $('#symbolCreatingBlock').show();
    });

    $('#form').submit(function(e) {
        // let canvas = new fabric.Canvas('symbolCanvas');
        // let code = canvas.toDataURL();
        // code = code.replace("data:image/png;base64,","");
        let url = $('#symbolPicture').attr('src');
        url = url.replace("data:image/png;base64,","");
        $('#imgUrl').val(url);
        console.log(url);
    });


});