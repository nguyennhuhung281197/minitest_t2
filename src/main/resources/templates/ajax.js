function showListPicture() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/picture",
        success(data) {
            let list = ``;
            list += `<table border="1px">
<tr>
                <td>Picture Name</td>
                <td>Height</td>
                <td>Width</td>
                <td>Material</td>
                <td>Description</td>
                <td>Price</td>
                <td>Category Name</td>
            </tr>`
            for (let i = 0; i < data.length; i++) {
                list += `<tr>

            <td>${data[i].pictureName}</td>
            <td>${data[i].height}</td>
            <td>${data[i].width}</td>
            <td>${data[i].material}</td>
            <td>${data[i].description}</td>
            <td>${data[i].price}</td>
            <td>${data[i].categories[0].categoryName}</td>
        </tr>`
            }
            list += `</table>`
            document.getElementById("display").innerHTML = list;
            console.log(list)
        }
    })
}

function createListPicture() {
    let form = ``
    form += `<table><tr>
<td>Picture Name</td>
<td><input type="text" id="pictureName"></td>
</tr>

<tr>
<td>Height</td>
<td><input type="text" id="height"></td>
</tr>

<tr>
<td>Width</td>
<td><input type="text" id="width"></td>
</tr>
<tr>
<td>Material</td>
<td><input type="text" id="material"></td>
</tr>
<tr>
<td>Description</td>
<td><input type="text" id="description"></td>
</tr>
<tr>
<td>Price</td>
<td><input type="text" id="price"></td>
</tr>
<tr>
<td>Category</td>
<td><select id="category"></select></td>
</tr>
<tr>
<td><button onclick="addPicture()">Add</button></td>
</tr>
</table>`
    document.getElementById("display").innerHTML = form;

    $.ajax({
        "type": "GET",
        "url": "http://localhost:8080/category",
        success(data) {
            let text = ``
            for (let i = 0; i < data.length; i++) {
                text += `<option value="${data[i].id}">${data[i].categoryName}</option>`
            }
            document.getElementById("category").innerHTML = text;
        }
    })
}

function addPicture() {
    let pictureName = $('#pictureName').val();
    let height = $('#height').val();
    let width = $('#width').val();
    let material = $('#material').val();
    let description = $('#description').val();
    let price = $('#price').val();
    let category = $("#category").val()
    let id = category[0]
    let categoryName = category[1]
    let categories = [{id, categoryName}]
    let newPicture = {
        pictureName: pictureName,
        height: height,
        width: width,
        material: material,
        description: description,
        price: price,
        categories: categories
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newPicture),
        url: "http://localhost:8080/picture",
        success() {
            showListPicture();
        }
    });
}

function searchOption() {
    let list = ``
    list += `<select id="category"></select>
<button onclick="showSearchOption()">Click</button>`
    document.getElementById("display").innerHTML = list;
    console.log(list)

    $.ajax({
        "type": "GET",
        "url": "http://localhost:8080/category",
        success(data) {
            let text = ``
            for (let i = 0; i < data.length; i++) {
                text += `<option value="${data[i].id}">${data[i].categoryName}</option>`
            }
            document.getElementById("category").innerHTML = text;
            console.log(text);
        }
    })

}

function showSearchOption() {
    let search1 = document.getElementById("category").value;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/picture/" + search1,
        success: function (data) {
            console.log(data);
            let list = ``;
            list += `
            <table border="1px">
                <tr>
                  
                    <th>Name</th>
                    <th>Height</th>
                    <th>Width</th>
                    <th>Material</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Categories</th
                </tr>`
            for (let i = 0; i < data.length; i++) {
                list += `<tr>
                    <td>${data[i].pictureName}</td>
                    <td>${data[i].height}</td>
                    <td>${data[i].width}</td>
                    <td>${data[i].material}</td>
                    <td>${data[i].description}</td>
                    <td>${data[i].price}</td>
               <td>${data[i].categories[0].categoryName}</td>
            
                    </tr>`;

                // for (let j = 0; j < data[i].categories.length; j++) {
                //     list += `${data[i].categories[j].name}`;
                //
                //     if (j < data[i].categories.length - 1) {
                //         list += ", ";
                //     }
                // }

            }
            list += `</table>`;
            document.getElementById("display").innerHTML = list;
        }
    })
}

function search() {
    let search1 = $('#name').val()
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/picture/search?name=" + search1,
        success(data1) {
            let list = ``;
            list += `<table border="1px">
<tr>
                <td>Picture Name</td>
                <td>Height</td>
                <td>Width</td>
                <td>Material</td>
                <td>Description</td>
                <td>Price</td>
                <td>Category Name</td>
            </tr>`
            for (let i = 0; i < data1.length; i++) {
                list += `<tr>

            <td>${data1[i].pictureName}</td>
            <td>${data1[i].height}</td>
            <td>${data1[i].width}</td>
            <td>${data1[i].material}</td>
            <td>${data1[i].description}</td>
            <td>${data1[i].price}</td>
            <td>${data1[i].categories[0].categoryName}</td>
        </tr>`
            }
            list += `</table>`
            document.getElementById("display").innerHTML = list;
        }

    })

}