$(document).ready(function() {
    $('#generateName').on('click', function() {
        $.ajax({
            url : '${pageContext.request.contextPath}/generateName',
            success : function(responseText) {
                $('#output').text(responseText);
            }
        });
    });
    $('#copyButton').on('click', function() {
        copyToClipboard();
    });

    function copyToClipboard() {
        new ClipboardJS('#copyButton');
    }
});