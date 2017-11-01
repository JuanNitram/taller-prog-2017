
$('.fj-date').datepicker({
    format: "dd/mm/yyyy",
    language: "es",

});

$('#datetimepicker1').on('changeDate', function(ev){
	$(this).datepicker('hide');
});



