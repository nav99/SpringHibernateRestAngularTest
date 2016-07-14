<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Syncom</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
</head>

<body>

<form id="interview">
    Enter Value:<br>
    <input type="text" id="value"><br>
    <input type="submit" value="Submit">
</form>


<script>
    $("#interview").submit(function (event) {
        event.preventDefault();
        var data = {};
        data.value = $('#value').val();
        $.ajax({
            type: "POST",
            url: "/",
            data: JSON.stringify(data),
            success: function () {
                alert("Added");
            },
            dataType: "json",
            contentType: "application/json"
        });

    });
</script>

</body>
</html>

<!-- Localized -->