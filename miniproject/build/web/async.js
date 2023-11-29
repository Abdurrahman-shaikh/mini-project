let caller = function(i,si){
    let xhr = new XMLHttpRequest();
    let data = document.getElementById(i).value;
    xhr.onreadystatechange=function(){
        if(xhr.readyState===4){
            if (xhr.status === 200) {
                  document.getElementById(si).innerHTML = xhr.responseText;
            } else {
                 document.getElementById(si).innerHTML="";
            }
        }
    };  
    xhr.open("get",`fc/?email=${data}&type=model&page=UserExistModel`,true);
    xhr.send(null);
};