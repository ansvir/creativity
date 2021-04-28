$(document).ready(function() {
    let records = [];
    let newLetterList = letterList;

    for (let i=0;i<letterList.length;i++) {
        $(`#range-${letterList[i].symbol}`).val(letterList[i].priority);
        $(`#rangeValue-${letterList[i].symbol}`).text(letterList[i].priority);
    }

    $('#settingsMsgSuccess').hide();
    $('#settingsMsgFail').hide();

    $('#nameLength').val(nameLength);

    $('#generateName').on('click', function () {
        records = [];
        for (let i = 0; i < 10; i++) {
            $.ajax({
                url: contextPath + '/creativity',
                data: {command: 'name_generation'},
                async: false,
                success: function (responseText) {
                    records.push(responseText);
                }
            });
        }
        recordsToOutput();
        fillNamesTable();
    });

    $('#copyButton').on('click', function () {
        copyToClipboard();
    });

    function copyToClipboard() {
        new ClipboardJS('#copyButton');
    }

    $('input[name="amountOfRecordsInOutputCheckbox"]').on('click', function () {
        recordsToOutput()
    })

    function recordsToOutput() {
        if ($('input[name="amountOfRecordsInOutputCheckbox"]:checked').length > 0) {
            $('#output').html(`<div>${records[0]}</div>`)
            for (let i = 1; i < 10; i++) {
                $('#output').append(`<div>${records[i]}</div>`);
            }
        } else {
            $('#output').html(`<div>${records[0]}</div>`);
        }
    }

    function fillNamesTable() {
        $('#emptyTextNameTable').hide();
        for (let i = 0; i < records.length; i++) {
            $('#namesTable tbody').append(`
                <tr>
                    <td>${records[i]}</td>                            
                </tr>
            `);
        }
    }

    // $('#namesTable').DataTable({
    //     "scrollY": "200px",
    //     "scrollCollapse": true,
    //     "paging": false,
    //     "info": false,
    //     "searching": false,
    //     "ordering": false
    // });

    $('#clearNamesTableData').on('click', function () {
        $('#namesTable tbody').html(`
        <tr>
            <td id="emptyTextNameTable" class="text-dark text-center">empty</td>
        </tr>
        `);
    });

    for (let i=0;i<letterList.length;i++) {
        $(`#range-${letterList[i].symbol}`).change(function () {
            newLetterList[i].priority = parseInt($(`#range-${letterList[i].symbol}`).val());
            $(`#rangeValue-${letterList[i].symbol}`).text(newLetterList[i].priority);
            letterList = newLetterList;
        });
    }

    $('#restoreDefaults').on('click', function() {
        $('#restoreDefaultsValue').val("true");
    });

    $('#settingsForm').submit(function(e) {
        if ($('#restoreDefaultsValue').val() === "true") {
            return;
        }

        console.log($('#generateLastName').val());
        
        let prioritySum = 0;
        for (let i=0;i<vowels.length;i++) {
            prioritySum += parseInt($(`#range-${vowels[i]}`).val());
        }
        console.log("vowels sum" + prioritySum);
        if (prioritySum === 0) {
            $('#settingsMsgFail').text("Vowels aren't appear in the name").show();
            e.preventDefault();
            return;
        }
        prioritySum = 0;
        for (let i=0;i<consonants.length;i++) {
            prioritySum += parseInt($(`#range-${consonants[i]}`).val());
        }
        if (prioritySum === 0) {
            $('#settingsMsgFail').text("Consonants aren't appear in the name").show();
            e.preventDefault();
        }
    });
});