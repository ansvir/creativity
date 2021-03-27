$(document).ready(function() {
        $('#selectLanguage').change(function() {
            $('#cultureDetails').empty();
            $('#languageDetails').empty();
            let languageId = $('#selectLanguage').val();
            if (languageId === "None") {
                $('#cultureDetails').empty();
                $('#languageDetails').empty();
                return;
            }
            $.ajax({
                url: contextPath + '/creativity',
                data: {
                    languageId: languageId,
                    command: "language_editor_get_cultures"
                },
                async: false,
                success: function (responseText) {
                    $('#cultureDetails').load(responseText+' #culturesDetailsBlock');
                    console.log(responseText);
                    console.log(languages);
                    console.log(cultures);
                }
            });
        });

        $(document).on('change', '#selectCulture', function() {
            console.log('enter on change selectCulture')
            $('#languageDetails').empty();
            let cultureId = $('#selectCulture').val();
            if (cultureId === 'None') {
                $('#languageDetails').empty();
                return;
            }
            $.ajax({
                url: contextPath + '/creativity',
                data: {
                    cultureId: cultureId,
                    command: "language_editor_get_details"
                },
                async: false,
                success: function (responseText) {
                    $('#languageDetails').load(responseText+' #languageDetailsBlock');
                    console.log(responseText);
                    console.log(languages);
                    console.log(cultures);
                }
            });
        });
});