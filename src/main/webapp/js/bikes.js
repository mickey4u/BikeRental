function loadBikesViews(json) {
    $("#goBack").css({
        display: "block"
    });
    if(json.length===0)
    {
        json = "<p>Bikes Not Available</p>";
    }
    $("#grid").jqGrid({
        datatype: "local",
        height: 280,
        colNames: ['ID','Description','Spot', 'Variant','Fare',''],
        colModel: [
            { name: 'bikeId', key: true, sorttype: "int", width: 80 },
            { name: 'bikeIcon', fixed: true ,width: 80 },
            { name: 'bikeSpot', width: 80  },
            { name: 'bikeType', width: 80  },
            { name: 'Fare', width: 80  },
            { name: '', align: 'center', sortable: false, width: 40,
                formatter: function () {
                    var grid = $('#grid'), rowid = $(this).closest("tr.jqgrow").attr("id");
                    var myCellData = grid.jqGrid('getCell', rowid, 'bikeId');
                    return "<a href='#' onclick='bookBike()'>Book</a>"; } }
        ],
        caption: "Bikes",
        data: json,
        gridview: true,
        sortname: "bikeId",
        onCellSelect: function (rowid) {
            var rowData = $(this).jqGrid("getRowData", rowid);
            selectedBikeJson = rowData
        }
    });
}
/*
* Checks if a location has been chosen or not
*
* */
function checkSelection() {
    if(selectedBikeSpot.toString().length>0)
    {
        getAvailabilty();
    }
    else
    {
        alert("Choose a Bike Spot");
    }
}
function returnBike()
{
    $.ajax({
        type: 'GET',url: "returnBike",dataType: "json",
        data: {

        },
        success: function (json){
           alert(json);
        },
        error: function (xhr) {
            alert("Error:" + "Ooooops! We're down. Come back again.");
        }
    });
}

/*
* Fetches Availability
* */
function getAvailabilty()
{
    var array = [];
    $.ajax({
        type: 'GET',url: "fetchAvailabilityData",dataType: "json",
        data: {bikeSpotLocation: selectedBikeSpot.toString()},
        success: function (json){
            $("#secondWindow").show();
            $("#map").hide();
            $("#lowerPanel").hide();
            for (var index = 0; index < json.length; index++) {
                array.push({
                    "bikeId": json[index].bikeId,
                    "bikeIcon": "images/Logo.png",
                    "bikeSpot":selectedBikeSpot ,
                    "bikeType": json[index].bikeType,
                    "Fare": json[index].rate+"/Hour"
                });
            }
            loadBikesViews(array);
        },
        error: function (xhr) {
            alert("Error:" + "Ooooops! We're down. Come back again.");
        }
    });
}

/*
*
* Books a Bike on click of Book
*
* */
function bookBike() {
    var jsonData = selectedBikeJson;
    var bookingID = "";
    var bikeId = jsonData.bikeId;
    var bookingType = "INSTANT_BOOKING";
    var bikeType = jsonData.bikeType;
    var bikeSpot = jsonData.bikeSpot;
    console.log(jsonData);
    {
        $.ajax({
            type: 'GET',
            url: "bookInstant",
            dataType: "json",
            data: {
                bikeId: bikeId,
                bookingType: bookingType,
                bikeSpot: bikeSpot
            },
            success: function (json){
                var bookingStatus = json.toString();
                if (bookingStatus !== "true") {

                } else {
                    $("#goBack").click();
                    ShowDialogBox('Title', 'Booking Successful.', 'Ok', '', 'GoToAssetList', null);
                }

            },
            error: function (xhr) {
                alert("Error:" + "Ooooops! We're down. Come back again.");
            }
        });
    }
}

function ShowDialogBox(title, content, btn1text, btn2text, functionText, parameterList) {
    var btn1css;
    var btn2css;
    $('.selector').dialog('option', 'position', 'top');
    if (btn1text == '') {
        btn1css = "hidecss";
    } else {
        btn1css = "showcss";
    }
    if (btn2text == '') {
        btn2css = "hidecss";
    } else {
        btn2css = "showcss";
    }
    $("#lblMessage").html(content);
    $("#dialog").dialog({
        resizable: false,
        title: title,
        modal: true,
        width: '400px',
        height: 'auto',
        bgiframe: false,
        hide: { effect: 'scale', duration: 100 },

        buttons: [
            {
                text: btn1text,
                "class": btn1css,
                click: function () {

                    $("#dialog").dialog('close');

                }
            },
            {
                text: btn2text,
                "class": btn2css,
                click: function () {
                    $("#dialog").dialog('close');
                }
            }
        ]
    });
}

function loadRentalHistory()
{
    {
        $.ajax({
            type: 'GET',
            url: "viewRentalHistory",
            dataType: "json",
            data: {
                username: "2037"
            },
            success: function (json){
               alert(json);
            },
            error: function (xhr) {
                alert("Error:" + "Ooooops! We're down. Come back again.");
            }
        });
    }
}