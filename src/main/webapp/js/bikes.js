function loadBikesViews(json) {
$("#goBack").show();
    $("#grid").jqGrid({
        datatype: "local",
        height: 350,
        colNames: ['bikeId','Bike Icon','bikeSpot', 'bikeType','Fare',''],
        colModel: [
            { name: 'bikeId', key: true, sorttype: "int", width: 80 },
            { name: 'bikeIcon', key: true, editype:"image",width: 80 },
            { name: 'bikeSpot', width: 80  },
            { name: 'bikeType', width: 80  },
            { name: 'Fare', width: 80  },
            { name: '', align: 'center', sortable: false, width: 40,
                formatter: function () { return "<a href='#'>Book</a>"; } }
        ],
        caption: "Bikes",
        data: json,
        gridview: true,
        sortname: "bikeId",
        beforeSelectRow: function (rowid, e) {
            var $self = $(this),
                $td = $(e.target).closest("td"),
                rowid = $td.closest("tr.jqgrow").attr("id"),
                iCol = $.jgrid.getCellIndex($td[0]),
                cm = $self.jqGrid("getGridParam", "colModel");
            if (cm[iCol].name === "edit" && e.target.tagName.toUpperCase() === "A") {
                alert('Edit id: ' + rowid);
                return false; // don't select the row on click
            }
            return true;
        }
    });
}

function fetchAvailability() {
    var bookingID = "";
    var bikeId = "";
    var bookingType = "";
    var status = "";
    var bikeSpot = "Stables";
    {
        $.ajax({
            type: 'GET',
            url: "fetchAvailabilityData",
            dataType: "json",
            data: {
                bikeSpotLocation: bikeSpot
            },
            success: function (json) {
                $("#secondWindow").show();
                $("#map").hide();
                $("#lowerPanel").hide();
                var array = [];
                for (var index = 0; index < json.length; index++) {
                    array.push({
                        "bikeId": json[index].bikeId,
                        "bikeIcon": "https://www.w3schools.com/css/trolltunga.jpg",
                        "bikeSpot": "stables",
                        "bikeType": "Gear",
                        "Fare": "1Euro/Hr"
                    });
                }
                console.log(array);
                loadBikesViews(array);
            },
            error: function (xhr) {
                alert("Error:" + "Ooooops! We're down. Come back again.");
            }
        });
    }
}