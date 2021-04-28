$(document).ready(function () {
    let cultures;
    let alphabet;
    $('#selectLanguage').change(function () {
        $('#cultureDetails').empty();
        $('#languageDetails').empty();
        $('#alphabetTableBody').empty();
        let languageId = $('#selectLanguage').val();
        if (languageId === "None") {
            $('#cultureDetails').empty();
            $('#languageDetails').empty();
            $('#alphabetTableBody').empty();
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
                $('#cultureDetails').append(`
                    <div class="form-group">
                        <label for="selectCulture">Culture</label>
                            <select class="form-control" id="selectCulture">
                                <option>None</option>
                    `);
                $(cultures).each(function () {
                    $('#selectCulture').append($('<option>', {
                        value: this.id,
                        text : this.name
                    }));
                });
                $('#cultureDetails').append(`
                            </select>
                    </div>`);
            }
        });
    });

    $(document).on('change', '#selectCulture', function () {
        $('#languageDetails').empty();
        $('#alphabetTableBody').empty();
        let cultureId = $('#selectCulture').val();
        if (cultureId === 'None') {
            $('#languageDetails').empty();
            $('#alphabetTableBody').empty();
            return;
        }
        $.ajax({
            url: contextPath + '/creativity',
            data: {
                cultureId: cultureId,
                command: "language_editor_get_details"
            },
            success: function (responseText) {
                let response = JSON.parse(responseText);
                let attributes = response.attributes;
                $('#languageDetails').load(response.pageName+' #languageDetailsBlock');
                alphabet = JSON.parse(attributes.alphabet);
                if (alphabet.length === 0) {
                    $('#alphabetTableBody').append(`
                        <tr>
                            <td colspan="3"
                                class="text-dark text-center">
                                You have no symbols yet
                            </td>
                        </tr>
                    `);
                } else {
                    $(alphabet).each(function() {
                        $('#alphabetTableBody').append(`
                            <tr>
                                <td class="text-center"><img
                                        src="${contextPath}/symbol/figures/${this.id}"
                                        alt="Symbol ${this.key}" width="35" height="35">
                                </td>
                                <td class="text-center">${this.key}</td>
                                <td class="text-center">[${this.transcription}]</td>
                            </tr>
                        `);
                    })
                }
            }
        });
    });
});