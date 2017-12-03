/*
* Creates the jQGrid for displaying the List of Bikes in a Given bike Spot
*
* */
var bikeCancelRow= "";

/**
 * Loads the available Bikes
 * @param json
 */
function loadBikesViews(json) {
    $("#goBack").css({
        display: "block"
    });
    if(json.length===0)
    {
        json = "<html><p>Bikes Not Available</p></html>";
    }
    $("#grid").jqGrid({
        datatype: "local",
        height: 280,
        width:600,
        colNames: ['ID','Description','Spot', 'Variant','Rate',''],
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
* Method to start a trip(Simulation feature)
*
* */
function startTrip()
{

    var values = username.split(" ");
    var f_part = values[0];
    var u_name = values[1] ? username.substr(username.indexOf(' ') + 1) : '';
    $.ajax({
        type:'GET',
        url: "startTrip",
        dataType: "json",
        data:{
            bookingID: bikeCancelRow
        },
        success: function(json){
            console.log(json);
                    },
        error: function (xhr) {
            alert("Error:" + "Ooooops! We're down. Come back again.");
        }
    })
}

/**
 *
 */
function endTrip()
{
var bookingID = bikeCancelRow;
    {
        $.ajax({
            type: 'GET',
            url: "endBooking",
            dataType: "json",
            data: {
                bookingID: bookingID
            },
            success: function (json){

                    displayFare(bookingID);

            },
            error: function (xhr) {
                alert("Error:" + "Ooooops! We're down. Come back again.");
            }
        });
    }
}

/**
 * To display the Total Calculated Fare
 * @param bookingID
 */
function displayFare(bookingID){
    jQuery.ajax({
        type: 'GET',
        url: 'displayFare',
        dataType: "json",
        data: {
            bookingID: bookingID
        },
        success: function (json){
            console.log("fare is=="+ json);
            ShowDialogBox("Total Fare", json, "Ok", null, "GoToAssetList", null)
        },
        error: function (xhr) {
            alert("Error:" + "Ooooops! We're down. Come back again.");
        }
    })
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
                    "bikeIcon": (json[index].bikeType.replace(/_/g,' ')).toLowerCase(),
                    "bikeSpot":selectedBikeSpot ,
                    "bikeType": (json[index].bikeType.replace(/_/g,' ')).toLowerCase(),
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
    var values = username.split(" ");
    var f_part = values[0];
    var u_name = values[1] ? username.substr(username.indexOf(' ') + 1) : '';
    console.log(jsonData);
    {
        $.ajax({
            type: 'GET',
            url: "bookInstant",
            dataType: "json",
            data: {
                bikeId: bikeId,
                bookingType: bookingType,
                bikeSpot: bikeSpot,
                username: u_name
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
/*
* Responsible for retrieving the rental history of the user
* */
function loadRentalHistory()
{
    var values = username.split(" ");
    var f_part = values[0];
    var u_name = values[1] ? username.substr(username.indexOf(' ') + 1) : '';
    {
        $.ajax({
            type: 'GET',
            url: "viewRentalHistory",
            dataType: "json",
            data: {
                username: u_name
            },
            success: function (json){
                createRentalHistoryable(json);
            },
            error: function (xhr) {
                alert("Error:" + "Ooooops! We're down. Come back again.");
            }
        });
    }
}
function createRentalHistoryable(json) {
    if(json.length===0)
    {
        json = "<html><p>You're yet to ride with us</p></html>";
    }
    jQuery('#grid1').trigger( 'reloadGrid' );
    jQuery('#grid1').jqGrid('clearGridData');
    jQuery("#grid1").jqGrid({
        datatype: "local",
        height: 300,
        width:600,
        colNames: ['Bike ID','Bike Spot','Booking ID','','Start Booking','End Booking'],
        colModel: [
            { name: 'bikeId', key: true, sorttype: "int", width: 120 },
            { name: 'bikeSpot', fixed: true ,width: 120 },
            { name: 'bookingId', width: 120  },
            {
                name: '', align: 'center', sortable: false, width: 80,
                formatter: function () {
                    var grid = $('#grid'), rowid = $(this).closest("tr.jqgrow").attr("id");
                    var myCellData = grid.jqGrid('getCell', rowid, 'bikeId');
                    return "<a href='#' onclick='cancelBooking()'>Cancel Booking</a>";
                },
            },
            { name: '', align: 'center', sortable: false, width: 80,
                formatter: function () {
                    var grid = $('#grid'), rowid = $(this).closest("tr.jqgrow").attr("id");
                    var myCellData = grid.jqGrid('getCell', rowid, 'bikeId');
                    return "<a href='#' onclick='startTrip()'>Start trip</a>"; }
            },
            { name: '', align: 'center', sortable: false, width: 80,
                formatter: function () {
                    var grid = $('#grid'), rowid = $(this).closest("tr.jqgrow").attr("id");
                    var myCellData = grid.jqGrid('getCell', rowid, 'bikeId');
                    return "<a href='#' onclick='endTrip()'>End trip</a>"; }
            }
            ],
        caption: "Rental History",
        data: json,
        gridview: true,
        onCellSelect: function (rowid) {
            var rowData = $(this).jqGrid("getRowData", rowid);
            bikeCancelRow = rowData.bookingId;
            console.log(bikeCancelRow);
        }
    });
}
/*
* To Cancel A BOOKING
* */
function cancelBooking()
{
    alert(bikeCancelRow);
    {
        $.ajax({
            type: 'POST',
            url: "cancelBooking",
            dataType: "json",
            data: {
                bookingID: bikeCancelRow
            },
            success: function (json){
                alert(json);
                loadRentalHistory();
            },
            error: function (xhr) {
                alert("Error:" + "Ooooops! We're down. Come back again.");
            }
        });
    }
}
