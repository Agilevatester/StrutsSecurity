<html>
<head>
    <title>AJAX Example</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $("#submitButton").click(function() {
                const name = $("#name").val();
                const age = $("#age").val();

                $.ajax({
                    url: 'ajax/submitData',
                    type: 'POST',
                    data: { name: name, age: age },
                    success: function(response) {
                        alert("Response: " + JSON.stringify(response));
                    },
                    error: function() {
                        alert("An error occurred.");
                    }
                });
            });
        });
    </script>
</head>
<body>
    <h1>Submit Data via AJAX</h1>
    <form>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required />
        <br />
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required />
        <br />
        <button type="button" id="submitButton">Submit</button>
    </form>
</body>
</html>