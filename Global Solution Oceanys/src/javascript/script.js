//menu hamburguer para responsividade
$(document).ready(function(){
    $('.mobile_btn').on('click', function(){
        $('#mobile_menu').toggleClass('active');
    });

    //animações

    const sections = $('section');
    const navItems = $('.nav-item');

    $(window).on('scroll', function(){
        const header = $('header');
        let activeSectionIndex = 0;

        const scrollPosition = $(window).scrollTop() - header.outerHeight();

        
        if (scrollPosition <=0 ){
            header.css('box-shadow', 'none');

        }else{
            header.css('box-shadow', '5px 1px 5px rgba(0, 0, 0.1');
        }

        sections.each(function(i){
            const section = $(this);
            const sectionTop = section.offset().top - 96;
            const sectionBottom = sectionTop + section.outerHeight();

            if(scrollPosition >= sectionTop && scrollPosition < sectionBottom){
                activeSectionIndex = i;
                return false;
            }
        })

        navItems.removeClass('active');
        $(navItems[activeSectionIndex]).addClass('active');
    });
    
    ScrollReveal().reveal('#cta', {
        origin: 'left',
        duration: 2000,
        distance: '20%'
    });

    ScrollReveal().reveal('#banner', {
        origin: 'right',
        duration: 2000,
        distance: '30%'
    });

    ScrollReveal().reveal('.infos2', {
        origin: 'right',
        duration: 2000,
        distance: '20%'
    });
   

    //charts
    $(function(){
        $('.bars li .bar').each(function(key, bar){
            var percentage = $(this).data('percentage');
            $(this).animate({
                'height': percentage + '%'
            }, 1000);
        });
    });
});
