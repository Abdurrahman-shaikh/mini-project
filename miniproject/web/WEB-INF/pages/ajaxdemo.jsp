<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>

            function call() {
                let selectElement = document.getElementsByName("countries")[0];
                let val = selectElement.options[selectElement.selectedIndex].value;
                console.log(val);

                let xhr = new XMLHttpRequest();

                xhr.onreadystatechange = function () {
                    if (xhr.readyState === 4) {
                        if (xhr.status === 200) {
                            let jsonValue = JSON.parse(xhr.responseText);
                            let states = jsonValue.states;

                            let statesDropdown = document.getElementsByName("states")[0];

                            statesDropdown.innerHTML = '<option value="">Select State</option>';

                            for (let i = 0; i < states.length; i++) {
                                let stateObject = states[i];
                                let key = Object.keys(stateObject)[0];
                                let value = stateObject[key];

                                // Create a new option element
                                let option = document.createElement("option");
                                option.value = key;
                                option.text = value + ' - ' + key;

                                statesDropdown.add(option);
                            }
                        } else {
                            console.log("not ok");
                        }
                    }
                };

                xhr.open("POST", "fc", true);
                xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                xhr.send("data=" + encodeURIComponent(val) + "&type=model&page=AjaxModel");
            }



        </script>
    </head>
    <body>
        <select name="countries" onchange="call()">
            <option name="country" value="">Select Country</option>
            <option name="India" value="91">India</option>
            <option name="USA" value="1">USA</option>
        </select>

        <select name="states">
            <option value="">Select State</option>
        </select>

        <div id="output"></div>
    </body>
</html>
