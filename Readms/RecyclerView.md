### Passo a Passo ReciclerView Java



  1 - Adicionar o componente RecyclerView na Activity xml ( e setar na classe java o iD do componente recyclerview)
  
  >
  2 - #### Configurar RecyclerView

             //criar e definir o layout do recyclerview
          - RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
             //encluir as definiçoes do leyout na reciclerview
          - recyclerView.setLayoutManager(layoutManager); 
              //adicionado na recycler view o adpter que foi criado
          - recyclerView.setAdapter(adpter); ( precisa criar o adptar)

--------------------------------------------------------------------------
           - //melhorar a performace
         recyclerView.setHasFixedSize(true); //metodo informa que vai posuir um tamanho fixo

         //Para criar uma linha divisoria entre os itens
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));


  3 - #### Configurar Adapter
                                             // a classe RecuclerView.Adpter vai didponobilizar os metodos necessarios 
    1 - criar Uma classe java Adapter e EXTENDER A clsse RecuclerView.Adpter<(adicionar o view holder)>

    2 - criar Uma classe ViewHolder dentro da classe Adapter que vai estender a classe RecuclerView.ViewHolder

    3 - Implementar os 3 metodos da classe RecuclerView
          - MyViewHolder (metodo que cria e recicla as visualização dos itens xml na tela)
          - onBindViewHolder ( metodo a recebe o conteudo do item especifico que vai aparecer na tela)
          - getItemCount

    4 - criar o Arquivo .xml com o modelo dos itens que vão aparecer na tela ( com o layout que vai aparecer dentro do recycler view)
       

    5 - Criar um contrutor no Adpter que vai receber a lista de dados que vai aparecer na Tela    


 ## Aplicar Eventos de clique dentro Da Lista RecyclerView

 1 - Adicionar o Metodo recyclerView.addOnItemTouchListener() dentro do metodo onCreate()

 2- Incluir no Projeto a Classe Pronta RecyclerItemClickListener para eventos de clique

 3 - Configuar a Motodo recyclerView.addOnItemTouchListener() com a classe Pronta "RecyclerItemClickListener" para configurar os metodos @Override
        
        ´´´
           - recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }

                            @Override
                            public void onItemClick(View view, int position) {

                            }

                            @Override
          -                  public void onLongItemClick(View view, int position) {
          -
          -                  }
         -               }
        -        )
       - );
       ´´´
  3 - configurar as ações de quando precionar na tela dentro dos metodo @Override 
      
        - public void onItemClick(View view, int position)  - clique curto
        - public void onLongItemClick(View view, int position) - clique longo
           

