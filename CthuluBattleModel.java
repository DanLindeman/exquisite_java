public class CthuluBattleModel
{
    private int cthulu_health, player_health, number_of_hits;

    public CthuluBattleModel()
    {

    }

    public void start(int good_big, int bad_big)
    {
        number_of_hits = 0;
        cthulu_health = bad_big;
        player_health = good_big;
    }

    public Integer get_cthulu_health()
    {
        return cthulu_health;
    }

    public Integer get_player_health()
    {
        return player_health;
    }

    public Integer get_good_integer()
    {
        return player_health;
    }

    public Integer get_bad_integer()
    {
        return number_of_hits;
    }

    public void punch()
    {
        number_of_hits = number_of_hits + 1;
        cthulu_health = cthulu_health - 4;
        cthulu_strike();
    }

    public void kick()
    {
        number_of_hits = number_of_hits + 1;
        cthulu_health = cthulu_health - 3;
        cthulu_strike();
    }

    public void cower()
    {
        player_health = player_health + 2;
    }

    public void cthulu_strike()
    {
        player_health = player_health - 5;
    }

}