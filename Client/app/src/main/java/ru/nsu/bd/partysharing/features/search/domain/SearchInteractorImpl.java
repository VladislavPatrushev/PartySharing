package ru.nsu.bd.partysharing.features.search.domain;

import ru.nsu.bd.partysharing.features.search.data.SearchDataSource;
import ru.nsu.bd.partysharing.network.Carry;
import ru.nsu.bd.partysharing.network.exchange.GetAllEventsResponse;

public class SearchInteractorImpl implements SearchInteractor{
    private final SearchDataSource dataSource;

    public SearchInteractorImpl(SearchDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void loadSearch(Long id, Carry<GetAllEventsResponse> carry) {
        dataSource.loadSearch(id, carry);
    }

    @Override
    public void findEventByName(GetAllEventsResponse mLoadedSearchList, String s) {

    }

    /*@RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<EventPreview> findEventByName(GetAllEventsResponse mLoadedSearchList, final String s) {
        Predicate condition = new Predicate() {
            public boolean test(Object list) {
                return ((EventPreview)((GetAllEventsResponse)list).getEvents()).getName().equals(s);
            }
        };
        return CollectionUtils.select( mLoadedSearchList.getEvents(), condition );

        /*List<EventPreview> result = mLoadedSearchList.getEvents().stream()
                .filter(item -> item.getName().equals("three"))
                .collect(Collectors.toList());
    }*/

    @Override
    public void findEventByCategory(GetAllEventsResponse mLoadedSearchList, String s) {

    }
}
